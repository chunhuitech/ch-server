package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.ProductActivityService;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import cn.chunhuitech.www.core.common.annotation.Skip;
import io.swagger.annotations.Api;
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
    private WXResult.Base report(ProductActivity productActivity) {
        return productActivityService.reportbyWx(productActivity);
    }
}
