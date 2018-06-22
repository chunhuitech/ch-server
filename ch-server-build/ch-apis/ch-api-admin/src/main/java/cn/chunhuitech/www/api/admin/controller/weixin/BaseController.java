package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.TokenInfoWrap;

import javax.servlet.http.HttpServletRequest;



/**
 * Created by hechengjin on 18-5-31.
 */
public class BaseController {
    public TokenInfoWrap getRequestUser(HttpServletRequest request) {
        return (TokenInfoWrap) request.getAttribute(ConstantApi.PARAM_USER);
    }
}
