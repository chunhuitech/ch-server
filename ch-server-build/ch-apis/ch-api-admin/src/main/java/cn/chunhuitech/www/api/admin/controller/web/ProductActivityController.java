package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.ProductActivitySearchBo;
import cn.chunhuitech.www.api.admin.model.ProductInfoSearchBo;
import cn.chunhuitech.www.api.admin.service.ProductActivityService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserSearchModel;
import cn.chunhuitech.www.core.admin.model.cus.ProductActivityPara;
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
@RequestMapping(value = "/web/activity")
public class ProductActivityController {

    @Autowired
    private ProductActivityService productActivityService;

    @Skip
    @RequestMapping(value = "/searchProductInfo", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<ProductInfoSearchBo> searchProductInfo() throws Exception{
        return productActivityService.getProductInfoList();
    }

    @Skip
    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<ProductActivitySearchBo> search(@RequestBody ProductActivityPara productActivityPara) throws Exception{
        return productActivityService.getList(productActivityPara);
    }

    @Skip
    @RequestMapping(value = "/mod", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage mod(@RequestBody ProductActivityPara productActivityPara) throws Exception{
        return productActivityService.mod(productActivityPara);
    }

}
