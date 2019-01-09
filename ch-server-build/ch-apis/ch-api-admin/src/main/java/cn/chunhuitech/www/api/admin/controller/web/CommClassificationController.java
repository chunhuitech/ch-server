package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.admin.service.CommClassificationService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.cus.CommResourcePara;
import cn.chunhuitech.www.core.admin.model.pojo.CommClassification;
import cn.chunhuitech.www.core.admin.model.pojo.CommResource;
import cn.chunhuitech.www.core.common.annotation.Skip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 18-2-22.
 */
@RestController
@Api(description = "web--分类接口")
@RequestMapping(value = "/web/class")
public class CommClassificationController {

    @Autowired
    private CommClassificationService commClassificationService;


    @Skip
    @ApiOperation(value = "web 获取子分类", notes = "根据父分类id获取其下所有分类")
    @RequestMapping(value = "/children", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommClassificationBo> fetchchildren(@RequestBody CommClassificationPara commClassificationPara) throws Exception{
        return commClassificationService.fetchChildren(commClassificationPara);
    }

    @Skip
    @ApiOperation(value = "web 获取所有分类", notes = "")
    @RequestMapping(value = "/all", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommClassificationBo> fetchall() throws Exception{
        return commClassificationService.fetchAll();
    }

    @Skip
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage add(@RequestBody CommClassification commClassification) throws Exception{
        return commClassificationService.add(commClassification);
    }

    @Skip
    @RequestMapping(value = "/mod", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage mod(@RequestBody CommClassification commClassification) throws Exception{
        return commClassificationService.mod(commClassification);
    }

    @Skip
    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage del(@RequestBody CommClassificationPara commClassificationPara) throws Exception{
        return commClassificationService.del(commClassificationPara);
    }

    @Skip
    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommClassification> getModel(@RequestBody CommClassificationPara commClassificationPara) {
        return commClassificationService.getModel(commClassificationPara);
    }
}
