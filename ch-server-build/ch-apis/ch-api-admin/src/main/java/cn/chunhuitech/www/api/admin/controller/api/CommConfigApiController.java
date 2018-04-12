package cn.chunhuitech.www.api.admin.controller.api;

import cn.chunhuitech.www.api.admin.model.CommConfigBo;
import cn.chunhuitech.www.api.admin.service.CommConfigService;
import cn.chunhuitech.www.api.admin.service.ProductActivityService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.pojo.ProductActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 18-2-22.
 */
@RestController
@RequestMapping(value = "/api/config")
public class CommConfigApiController {

    @Autowired
    private CommConfigService commConfigService;


    @RequestMapping(value = "/recorddataver", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommConfigBo> getRecordDataVersion() throws Exception{
        return commConfigService.getRecordDataVersion();
    }

}
