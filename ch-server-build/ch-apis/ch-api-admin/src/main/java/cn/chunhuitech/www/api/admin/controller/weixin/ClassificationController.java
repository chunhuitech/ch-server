package cn.chunhuitech.www.api.admin.controller.weixin;

import cn.chunhuitech.www.api.admin.model.CommClassificationBo;
import cn.chunhuitech.www.api.admin.service.CommClassificationService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.common.model.TokenInfoWrap;
import cn.chunhuitech.www.core.admin.model.cus.CommClassificationPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
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
@RequestMapping(value = "/weixin/class")
public class ClassificationController extends BaseController{

    @Autowired
    private CommClassificationService commClassificationService;



    @RequestMapping(value = "/children", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<CommClassificationBo> fetchchildren(@RequestBody CommClassificationPara commClassificationPara, HttpServletRequest request) throws Exception{
        TokenInfoWrap tokenInfoWrap = getRequestUser(request);
        return commClassificationService.fetchChildren(commClassificationPara);
    }

}
