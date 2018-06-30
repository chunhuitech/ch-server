package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.CommPointReadBlockService;
import cn.chunhuitech.www.api.admin.service.CommResourceService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.cus.CommPointReadBlockPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hechengjin on 18-2-22.
 */
@RestController
@RequestMapping(value = "/weixin/readpoint")
public class CommPointReadBlockWXController extends BaseController {

    @Autowired
    private CommPointReadBlockService commPointReadBlockService;

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base getreadPoint(HttpServletRequest request, CommPointReadBlockPara commPointReadBlockPara) throws Exception{
        return commPointReadBlockService.getPointReadBlock(commPointReadBlockPara, getRequestToken(request));
    }

}
