package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.CommCatalogService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hechengjin on 18-2-22.
 */
@RestController
@RequestMapping(value = "/weixin/catalog")
public class CommCatalogWXController extends BaseController{

    @Autowired
    private CommCatalogService commCatalogService;


//    @WeiXinSign
//    @Skip
    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base getcatalog(HttpServletRequest request, CommCatalogPara commCatalogPara) throws Exception{
        return commCatalogService.getCatalog(commCatalogPara, getRequestToken(request));
    }

}
