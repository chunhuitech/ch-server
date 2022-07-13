package cn.chunhuitech.www.api.admin.controller.portal;

import cn.chunhuitech.www.api.admin.controller.weixin.BaseController;
import cn.chunhuitech.www.api.admin.model.CommRecordSearchBo;
import cn.chunhuitech.www.api.admin.model.CommRecordWebSearchBo;
import cn.chunhuitech.www.api.admin.service.CommRecordService;
import cn.chunhuitech.www.api.admin.service.FilesService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import cn.chunhuitech.www.core.common.annotation.Skip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hechengjin on 17-9-29.
 */
@RestController
@Api(description = "portal--分类下的记录接口")
@RequestMapping(value = "/portal/record")
public class RecordPageController extends BaseController {



    @Autowired
    private CommRecordService commRecordService;



    @Skip
    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommRecordWebSearchBo> search(@RequestBody CommRecordPara commRecordPara) throws Exception{
        return commRecordService.getList2(commRecordPara);
    }
}
