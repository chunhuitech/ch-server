package cn.chunhuitech.www.api.admin.controller.api;

import cn.chunhuitech.www.api.admin.model.ProductInfoBo;
import cn.chunhuitech.www.api.admin.service.ProductActivityService;
import cn.chunhuitech.www.api.admin.service.ProductInfoService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import cn.chunhuitech.www.core.admin.model.pojo.ProductInfo;
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
@RequestMapping(value = "/api/prodinfo")
public class ProducInfoApiController {

    @Autowired
    private ProductInfoService productInfoService;

    @Skip
    @RequestMapping(value = "/versioncheck", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<ProductInfoBo> versionCheck(@RequestBody ProductInfo productInfo) throws Exception{
        return productInfoService.versionCheck(productInfo);
    }

}
