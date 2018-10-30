package cn.chunhuitech.www.api.common.interceptor;

import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.exception.*;
import cn.chunhuitech.www.api.common.model.TokenInfoWrap;
import cn.chunhuitech.www.api.common.util.JWT;
import cn.chunhuitech.www.api.common.util.TransUtils;
import cn.chunhuitech.www.core.common.annotation.Skip;
import cn.chunhuitech.www.core.common.annotation.WeiXinSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;

/**
 * Created by hechengjin on 18-5-31.
 */
public class WeiXinLoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WeiXinLoginInterceptor.class);

    @Value("${miniprogram.check.from}")
    private boolean checkFrom;

    @Value("${miniprogram.sign.secret}")
    private String signSecret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        WeiXinSign sign = null;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Skip skip = handlerMethod.getMethodAnnotation(Skip.class);
            sign = handlerMethod.getMethodAnnotation(WeiXinSign.class);
            if (skip != null) {
                return true;
            }
        } else {
            return super.preHandle(request, response, handler);
        }
        logger.debug("{}", request.getRequestURL()
                + (request.getQueryString() != null ? request.getQueryString() : ""));
        if (checkFrom) {
            if (!request.getHeader("User-Agent").contains("MicroMessenger/")) {
                throw new RequestSourceException();
            }
        }

        /** 检查数字签名 */
        if (sign != null) {
            if (!checkSign(request)){
                return false;
            }
        }
        String token = getTokenByRequest(request);
        if (!StringUtils.isEmpty(token) && !token.equals("[object Null]") && !token.equals("null")) {
            TokenInfoWrap tokenInfoWrap = JWT.unsign(token, TokenInfoWrap.class);
            if (tokenInfoWrap != null) {
                request.setAttribute(ConstantApi.HEAD_PARAM_USER_TOKEN, tokenInfoWrap);
                return true;
            }
            // 返回错误的Token
            throw new TokenErrorException();
        } else {
            // @sign方法,有token就验证身份，没有token就不验证身份
            if (sign != null) {
                return true;
            }
            throw new TokenNotFindException();
        }
    }

    private String getTokenByRequest(HttpServletRequest request) {
        if (!StringUtils.isEmpty(request.getHeader(ConstantApi.HEAD_PARAM_SECURITY_TOKEN))){
            return request.getHeader(ConstantApi.HEAD_PARAM_SECURITY_TOKEN);
        } else {
            return !StringUtils.isEmpty(request.getParameter(ConstantApi.HEAD_PARAM_SECURITY_TOKEN)) ?
                    request.getParameter(ConstantApi.HEAD_PARAM_SECURITY_TOKEN) : getParameterByCookie(request, ConstantApi.HEAD_PARAM_SECURITY_TOKEN);
        }
    }

    /** 从cookie中读取信息 */
    private String getParameterByCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    private boolean checkSign(HttpServletRequest request) throws Exception {
        String productId = request.getHeader(ConstantApi.HEAD_PARAM_SECURITY_PRODUCTID);
        String productVersion = request.getHeader(ConstantApi.HEAD_PARAM_SECURITY_PRODUCVERSION);
        String uuid = request.getHeader(ConstantApi.HEAD_PARAM_SECURITY_UUID);
        String timestamp = request.getHeader(ConstantApi.HEAD_PARAM_SECURITY_TIME);
        String sign = request.getHeader(ConstantApi.HEAD_PARAM_SECURITY_SIGN);
        if (productId == null || productVersion == null || uuid == null || timestamp == null ) {
            throw new ParamInvalidException();
        }

        if (sign == null) {
            throw new SignException();
        }

        //verify sign
        StringBuilder signSrc = new StringBuilder();
        signSrc.append(ConstantApi.HEAD_PARAM_SECURITY_PRODUCTID);
        signSrc.append("_");
        signSrc.append(productId);
        signSrc.append("*");
        signSrc.append(ConstantApi.HEAD_PARAM_SECURITY_PRODUCVERSION);
        signSrc.append("_");
        signSrc.append(productVersion);
        signSrc.append("*");
        signSrc.append(ConstantApi.HEAD_PARAM_SECURITY_TIME);
        signSrc.append("_");
        signSrc.append(timestamp);
        signSrc.append("*");
        signSrc.append(ConstantApi.HEAD_PARAM_SECURITY_UUID);
        signSrc.append("_");
        signSrc.append(uuid);

        MessageDigest md = MessageDigest.getInstance(ConstantApi.ALGORITHM_MD5);
        md.update(signSecret.getBytes());
        md.update(signSrc.toString().getBytes());

        String newSign = TransUtils.bytes2HexString(md.digest());
        logger.debug("signSrc:{}, sign:{}, newSign:{}", signSrc, sign, newSign);
        if (!sign.equals(newSign)) {
            throw new SignException();
        }
        return true;
    }
}
