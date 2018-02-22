package cn.chunhuitech.www.api.admin.controller.api;

import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.admin.service.CommClassificationService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 18-2-22.
 */
@RestController
@RequestMapping(value = "/api/class")
public class CommClassificationApiController {

    @Autowired
    private CommClassificationService commClassificationService;


    @RequestMapping(value = "/fetch", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommClassificationBo> fetchclass(@RequestBody CommClassificationPara commClassificationPara) throws Exception{
        return commClassificationService.fetchClass(commClassificationPara);
    }

}
