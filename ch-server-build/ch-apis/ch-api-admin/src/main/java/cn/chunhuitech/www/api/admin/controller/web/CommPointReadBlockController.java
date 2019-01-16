package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.CommPointReadBlockBo;
import cn.chunhuitech.www.api.admin.service.CommPointReadBlockService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommPointReadBlockPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommPointReadBlock;
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
@Api(description = "web--点读信息接口")
@RequestMapping(value = "/web/readpoint")
public class CommPointReadBlockController {

    @Autowired
    private CommPointReadBlockService commPointReadBlockService;

    @Skip
    @ApiOperation(value = "获取当前页点读信息", notes = "获取指定页面下的点读块信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageId", value = "分页id", paramType = "query", required = true)
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base getreadPoint(HttpServletRequest request, Integer pageId) throws Exception{
        CommPointReadBlockPara commPointReadBlockPara = new CommPointReadBlockPara();
        commPointReadBlockPara.setPageId(pageId);
        return commPointReadBlockService.getPointReadBlockAndroid(commPointReadBlockPara);
    }

    @Skip
    @RequestMapping(value = "/fetch", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommPointReadBlockBo> fetchReadPointBlock(@RequestBody CommPointReadBlockPara commPointReadBlockPara) throws Exception{
        return commPointReadBlockService.fetchPointReadBlock(commPointReadBlockPara);
    }

    @Skip
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage add(@RequestBody CommPointReadBlock commPointReadBlock) throws Exception{
        return commPointReadBlockService.add(commPointReadBlock);
    }

    @Skip
    @RequestMapping(value = "/mod", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage mod(@RequestBody CommPointReadBlock commPointReadBlock) throws Exception{
        return commPointReadBlockService.mod(commPointReadBlock);
    }

    @Skip
    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage del(@RequestBody CommPointReadBlockPara commPointReadBlockPara) throws Exception{
        return commPointReadBlockService.del(commPointReadBlockPara);
    }

    @Skip
    @RequestMapping(value = "/getModel", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommPointReadBlock> getModel(@RequestBody CommPointReadBlockPara commPointReadBlockPara) {
        return commPointReadBlockService.getModel(commPointReadBlockPara);
    }

}
