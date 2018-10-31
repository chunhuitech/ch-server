package cn.chunhuitech.www.api.admin.controller.api;

import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.admin.service.CommClassificationService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
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
@Api(description = "android--分类接口")
@RequestMapping(value = "/api/class")
public class CommClassificationApiController {

    @Autowired
    private CommClassificationService commClassificationService;

    @Skip
    @ApiOperation(value = "pc 保留", notes = "支持已发版本")
    @RequestMapping(value = "/fetch", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommClassificationBo> fetchclass(@RequestBody CommClassificationPara commClassificationPara) throws Exception{
        return commClassificationService.fetchClass(commClassificationPara);
    }

    @Skip
    @ApiOperation(value = "pc 保留", notes = "支持已发版本")
    @RequestMapping(value = "/children", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommClassificationBo> fetchchildren(@RequestBody CommClassificationPara commClassificationPara) throws Exception{
        return commClassificationService.fetchChildren(commClassificationPara);
    }

    @Skip
    @ApiOperation(value = "android 获取子分类", notes = "根据当前分类id获取其下所有分类")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "要查询分类的id", paramType = "query", required = true)
    })
    @RequestMapping(value = "/children", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base getchildren(HttpServletRequest request, Integer id) throws Exception{
        CommClassificationPara commClassificationPara = new CommClassificationPara();
        commClassificationPara.setParentId(id);
        return commClassificationService.getChildrenAndroid(commClassificationPara);
    }

}
