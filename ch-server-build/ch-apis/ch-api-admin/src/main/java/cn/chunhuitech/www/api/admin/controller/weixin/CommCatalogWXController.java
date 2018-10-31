package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.CommCatalogService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;
import cn.chunhuitech.www.core.common.annotation.Skip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hechengjin on 18-2-22.
 */
@RestController
@Api(description = "微信小程序--目录接口")
@RequestMapping(value = "/weixin/catalog")
public class CommCatalogWXController extends BaseController{

    @Autowired
    private CommCatalogService commCatalogService;


//    @WeiXinSign
//    @Skip
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    @ApiOperation(value = "书目录获取", notes = "获取目录信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "classId", value = "分类id", paramType = "query", required = true)
    })
    public WXResult.Base getcatalog(HttpServletRequest request, Integer classId) throws Exception{
        CommCatalogPara commCatalogPara = new CommCatalogPara();
        commCatalogPara.setClassId(classId);
        return commCatalogService.getCatalogMiniProg(commCatalogPara, getRequestToken(request));
    }

}
