package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.CommRecordService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hechengjin on 17-9-29.
 */
@RestController
@Api(description = "微信小程序--书页信息接口")
@RequestMapping(value = "/weixin/page")
public class CommRecordPageWXController extends BaseController{


    @Autowired
    private CommRecordService commRecordService;

    @ApiOperation(value = "书页信息", notes = "根据指定的书本id(classId),分页获取其书页信息")
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
        return commRecordService.getPageList(commRecordPara, getRequestToken(request));
    }

}
