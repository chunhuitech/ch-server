package cn.chunhuitech.www.api.admin.controller.api;

import cn.chunhuitech.www.api.admin.model.CommRecordBo;
import cn.chunhuitech.www.api.admin.model.CommRecordPagesBo;
import cn.chunhuitech.www.api.admin.service.CommRecordService;
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
 * Created by hechengjin on 18-2-22.
 */
@RestController
@Api(description = "android--分页接口")
@RequestMapping(value = "/api/record")
public class CommRecordApiController {

    @Autowired
    private CommRecordService commRecordService;

    @Skip
    @ApiOperation(value = "pc 保留", notes = "支持已发版本")
    @RequestMapping(value = "/fetch", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommRecordBo> fetchclass(@RequestBody CommRecordPara commRecordPara) throws Exception{
        return commRecordService.fetchRecord(commRecordPara);
    }

    @Skip
    @ApiOperation(value = "pc 保留", notes = "支持已发版本")
    @RequestMapping(value = "/fetchpageinfos", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommRecordPagesBo> fetchpageinfos(@RequestBody CommRecordPara commRecordPara) throws Exception{
        return commRecordService.fetchPageInfo(commRecordPara);
    }

    @Skip
    @ApiOperation(value = "android 书页信息", notes = "根据指定的书本id(classId),分页获取其书页信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "classId", value = "书本id", paramType = "query", required = true),
            @ApiImplicitParam(name = "page", value = "所有记录的第几页(不同于书页，是书页记录的分页)", paramType = "query", required = true),
            @ApiImplicitParam(name = "limit", value = "每页多少条返回", paramType = "query", required = true)
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base get(HttpServletRequest request, Integer classId, Integer page, Integer limit) throws Exception{
        CommRecordPara commRecordPara = new CommRecordPara();
        commRecordPara.setClassId(classId);
        commRecordPara.setPage(page);
        commRecordPara.setLimit(limit);
        return commRecordService.getPageListAndroid(commRecordPara);
    }

}
