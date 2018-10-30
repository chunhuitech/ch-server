package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.CommPointReadBlockService;
import cn.chunhuitech.www.api.admin.service.CommResourceService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.cus.CommPointReadBlockPara;
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
@Api(description = "微信小程序--点读信息接口")
@RequestMapping(value = "/weixin/readpoint")
public class CommPointReadBlockWXController extends BaseController {

    @Autowired
    private CommPointReadBlockService commPointReadBlockService;

    @ApiOperation(value = "获取点读信息", notes = "获取指定页面下的点读块信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageId", value = "分页id", paramType = "query", required = true)
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base getreadPoint(HttpServletRequest request, Integer pageId) throws Exception{
        CommPointReadBlockPara commPointReadBlockPara = new CommPointReadBlockPara();
        commPointReadBlockPara.setPageId(pageId);
        return commPointReadBlockService.getPointReadBlock(commPointReadBlockPara, getRequestToken(request));
    }

}
