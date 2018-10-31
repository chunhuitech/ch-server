package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.CommResourceService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
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
@Api(description = "微信小程序--书本资源（mp3等）接口")
@RequestMapping(value = "/weixin/resource")
public class CommResourceWXController extends BaseController {

    @Autowired
    private CommResourceService commResourceService;

    @ApiOperation(value = "书本资源", notes = "根据指定的书本id,获取书本资源")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "书本id", paramType = "query", required = true)
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base getresource(HttpServletRequest request, Integer id) throws Exception{
        CommClassificationPara commClassificationPara = new CommClassificationPara();
        commClassificationPara.setId(id);
        return commResourceService.getResourceMiniProg(commClassificationPara, getRequestToken(request));
    }

}
