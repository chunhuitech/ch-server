package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.CommClassificationService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hechengjin on 18-2-22.
 */
@RestController
@RequestMapping(value = "/weixin/class")
public class CommClassificationWXController extends BaseController {

    @Autowired
    private CommClassificationService commClassificationService;

//    @Skip
    @RequestMapping(value = "/children", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base getchildren(HttpServletRequest request, CommClassificationPara commClassificationPara) throws Exception{
        return commClassificationService.getChildren(commClassificationPara, getRequestToken(request));
    }

}
