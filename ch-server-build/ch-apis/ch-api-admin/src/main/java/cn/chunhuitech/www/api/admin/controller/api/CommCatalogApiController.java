package cn.chunhuitech.www.api.admin.controller.api;

import cn.chunhuitech.www.api.admin.model.CommCatalogBo;
import cn.chunhuitech.www.api.admin.service.CommCatalogService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.CommCatalogPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 18-2-22.
 */
@RestController
@RequestMapping(value = "/api/catalog")
public class CommCatalogApiController {

    @Autowired
    private CommCatalogService commCatalogService;


    @RequestMapping(value = "/fetch", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommCatalogBo> fetchcatalog(@RequestBody CommCatalogPara commCatalogPara) throws Exception{
        return commCatalogService.fetchCatalog(commCatalogPara);
    }

}
