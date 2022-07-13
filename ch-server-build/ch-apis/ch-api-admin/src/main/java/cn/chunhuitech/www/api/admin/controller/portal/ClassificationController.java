package cn.chunhuitech.www.api.admin.controller.portal;

import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.admin.service.CommClassificationService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;
import cn.chunhuitech.www.core.common.annotation.Skip;
import cn.chunhuitech.www.core.common.constant.ConstantCore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 05-7-22.
 */
@RestController
@Api(description = "portal--分类接口")
@RequestMapping(value = "/portal/class")
public class ClassificationController {

    @Autowired
    private CommClassificationService commClassificationService;


    @Skip
    @ApiOperation(value = "web 获取子分类", notes = "根据父分类id获取其下所有分类")
    @RequestMapping(value = "/children", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommClassificationBo> fetchchildren(@RequestBody CommClassificationPara commClassificationPara) throws Exception{
        return commClassificationService.fetchChildren(commClassificationPara, ConstantCore.STATUS_SHOW_YES, ConstantCore.STATUS_CLASS_DATA_TYPE_ALL);
    }

    @Skip
    @ApiOperation(value = "web 获取所有分类", notes = "")
    @RequestMapping(value = "/all", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommClassificationBo> fetchall() throws Exception{
        return commClassificationService.fetchAll(ConstantCore.STATUS_SHOW_ALL, ConstantCore.STATUS_CLASS_DATA_TYPE_ALL);
    }


}
