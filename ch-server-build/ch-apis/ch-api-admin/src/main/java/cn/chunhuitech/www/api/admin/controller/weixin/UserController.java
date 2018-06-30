package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.AdminUserService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.WXErrorCode;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.WeiXinLoginParam;
import cn.chunhuitech.www.core.common.annotation.Skip;
import cn.chunhuitech.www.core.common.annotation.WeiXinSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by hechengjin on 18-5-31.
 */
@RestController
@RequestMapping(value = "/weixin/user")
public class UserController extends BaseController{
    @Autowired
    private AdminUserService adminUserService;

    @WeiXinSign
//    @Skip
    @PostMapping("/login")
//    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    private WXResult.Base login(WeiXinLoginParam weiXinLoginParam) {

        try {
            weiXinLoginParam.setEncryptedData(URLDecoder.decode(weiXinLoginParam.getEncryptedData(), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (StringUtils.isEmpty(weiXinLoginParam.getCode()) ||
                StringUtils.isEmpty(weiXinLoginParam.getEncryptedData()) ||
                StringUtils.isEmpty(weiXinLoginParam.getIv())) {
            return WXErrorCode.ARGUMENT_INVALID;
        }

        return adminUserService.wxLogin(weiXinLoginParam);

    }
}
