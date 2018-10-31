package cn.chunhuitech.www.api.admin.controller.api;

import cn.chunhuitech.www.api.admin.model.CommResourceBo;
import cn.chunhuitech.www.api.admin.service.CommResourceService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.common.annotation.Skip;
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
@RequestMapping(value = "/api/resource")
public class CommResourceApiController {

    @Autowired
    private CommResourceService commResourceService;

    @Skip
    @ApiOperation(value = "pc 保留", notes = "支持已发版本")
    @RequestMapping(value = "/fetch", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommResourceBo> fetchresource(@RequestBody CommClassificationPara commClassificationPara) throws Exception{
        return commResourceService.fetchResource(commClassificationPara);
    }

    @Skip
    @ApiOperation(value = "书本资源", notes = "根据指定的书本id,获取书本资源")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "书本id", paramType = "query", required = true)
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base getresource(HttpServletRequest request, Integer id) throws Exception{
        CommClassificationPara commClassificationPara = new CommClassificationPara();
        commClassificationPara.setId(id);
        return commResourceService.getResourceAndroid(commClassificationPara);
    }

}
