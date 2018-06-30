package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.service.CommRecordService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.WXResult;
import cn.chunhuitech.www.core.admin.model.cus.CommRecordPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hechengjin on 17-9-29.
 */
@RestController
@RequestMapping(value = "/weixin/page")
public class CommRecordPageWXController extends BaseController{


    @Autowired
    private CommRecordService commRecordService;


    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public WXResult.Base get(HttpServletRequest request, CommRecordPara commRecordPara) throws Exception{
        return commRecordService.getPageList(commRecordPara, getRequestToken(request));
    }

}
