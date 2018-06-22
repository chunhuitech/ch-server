package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.CommResourceBo;
import cn.chunhuitech.www.api.admin.service.CommResourceService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
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
@RequestMapping(value = "/web/resource")
public class CommResourceController {

    @Autowired
    private CommResourceService commResourceService;


    @Skip
    @RequestMapping(value = "/fetch", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommResourceBo> fetchresource(@RequestBody CommClassificationPara commClassificationPara) throws Exception{
        return commResourceService.fetchResource(commClassificationPara);
    }

}
