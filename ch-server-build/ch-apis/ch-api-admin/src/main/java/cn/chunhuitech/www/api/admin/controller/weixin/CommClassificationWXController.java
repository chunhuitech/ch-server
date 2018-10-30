package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.CommClassificationService;
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
@Api(description = "微信小程序--分类接口")
@RequestMapping(value = "/weixin/class")
public class CommClassificationWXController extends BaseController {

    @Autowired
    private CommClassificationService commClassificationService;

//    @Skip
    @ApiOperation(value = "获取子分类", notes = "根据当前分类id获取其下所有分类")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "要查询分类的id", paramType = "query", required = true)
    })
    @RequestMapping(value = "/children", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base getchildren(HttpServletRequest request, Integer id) throws Exception{
        CommClassificationPara commClassificationPara = new CommClassificationPara();
        commClassificationPara.setParentId(id);
        return commClassificationService.getChildren(commClassificationPara, getRequestToken(request));
    }

}
