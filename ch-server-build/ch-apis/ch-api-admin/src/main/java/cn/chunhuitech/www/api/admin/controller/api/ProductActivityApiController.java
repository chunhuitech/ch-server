package cn.chunhuitech.www.api.admin.controller.api;

import cn.chunhuitech.www.api.admin.service.ProductActivityService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import cn.chunhuitech.www.core.common.annotation.Skip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 18-2-22.
 */
@RestController
@RequestMapping(value = "/api/prodactivity")
public class ProductActivityApiController {

    @Autowired
    private ProductActivityService productActivityService;

    @Skip
    @RequestMapping(value = "/report", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage report(@RequestBody ProductActivity productActivity) throws Exception{
        return productActivityService.report(productActivity);
    }

}
