package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.ProductActivityService;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import cn.chunhuitech.www.core.common.annotation.Skip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by hechengjin on 18-5-31.
 */
@RestController
@Api(description = "微信小程序--产品活跃埋点接口")
@RequestMapping(value = "/weixin/prodactivity")
public class ActivityController extends BaseController{
    @Autowired
    private ProductActivityService productActivityService;


    @Skip
    @PostMapping("/report")
    @ApiOperation(value = "产品活跃埋点接口", notes = "上传客户端相关信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "用户id", paramType = "query", required = true),
            @ApiImplicitParam(name = "procId", value = "产品id", paramType = "query", required = true),
            @ApiImplicitParam(name = "procName", value = "产品名称", paramType = "query", required = true),
            @ApiImplicitParam(name = "procVersion", value = "产品版本", paramType = "query", required = true),
            @ApiImplicitParam(name = "eventName", value = "事件名称", paramType = "query", required = true)
    })
    public WXResult.Base report(Long userId, Long procId, String procName, String procVersion, String eventName) {
        ProductActivity productActivity = new ProductActivity();
        productActivity.setUserId(userId);
        productActivity.setProcId(procId);
        productActivity.setProcName(procName);
        productActivity.setProcVersion(procVersion);
        productActivity.setEventName(eventName);
        return productActivityService.reportbyWx(productActivity);
    }
}
