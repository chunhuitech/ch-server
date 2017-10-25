package cn.chunhuitech.www.api.xf.controller.web;

import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.api.xf.model.XfSchoolModelSearch;
import cn.chunhuitech.www.api.xf.service.XfSchoolService;
import cn.chunhuitech.www.core.xf.model.cus.XfSchoolPara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 17-9-29.
 */
@RestController
@RequestMapping(value = "/web/school")
public class XfSchoolController {


    @Autowired
    private XfSchoolService xfSchoolService;


    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<XfSchoolModelSearch> search(@RequestBody XfSchoolPara xfSchoolPara) throws Exception{
        return xfSchoolService.getList(xfSchoolPara);
    }
}
