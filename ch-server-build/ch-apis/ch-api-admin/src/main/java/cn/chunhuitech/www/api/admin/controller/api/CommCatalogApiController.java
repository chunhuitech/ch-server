package cn.chunhuitech.www.api.admin.controller.api;

import cn.chunhuitech.www.api.admin.model.CommCatalogBo;
import cn.chunhuitech.www.api.admin.service.CommCatalogService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;
import cn.chunhuitech.www.core.common.annotation.Skip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hechengjin on 18-2-22.
 */
@RestController
@Api(description = "android--目录接口")
@RequestMapping(value = "/api/catalog")
public class CommCatalogApiController {

    @Autowired
    private CommCatalogService commCatalogService;


    @Skip
    @ApiOperation(value = "pc 保留", notes = "支持已发版本")
    @RequestMapping(value = "/fetch", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommCatalogBo> fetchcatalog(@RequestBody CommCatalogPara commCatalogPara) throws Exception{
        return commCatalogService.fetchCatalog(commCatalogPara);
    }

    @Skip
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    @ApiOperation(value = "android 书目录获取", notes = "获取目录信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "classId", value = "分类id", paramType = "query", required = true)
    })
    public WXResult.Base getcatalog(Integer classId) throws Exception{
        CommCatalogPara commCatalogPara = new CommCatalogPara();
        commCatalogPara.setClassId(classId);
        return commCatalogService.getCatalogAndorid(commCatalogPara);
    }

}
