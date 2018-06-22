package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.AdminSystemSearchBo;
import cn.chunhuitech.www.api.admin.service.AdminSystemService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.AdminSystemPara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminSystem;
import cn.chunhuitech.www.core.common.annotation.Skip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hechengjin on 17-9-29.
 */
@RestController
@RequestMapping(value = "/web/system")
public class AdminSystemController {


    @Autowired
    private AdminSystemService adminSystemService;


    @Skip
    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminSystemSearchBo> search(@RequestBody AdminSystemPara adminSystemPara) throws Exception{
        return adminSystemService.getList(adminSystemPara);
    }

    @Skip
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage add(@RequestBody AdminSystem adminSystem) throws Exception{
        return adminSystemService.add(adminSystem);
    }

    @Skip
    @RequestMapping(value = "/mod", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage mod(@RequestBody AdminSystem adminSystem) throws Exception{
        return adminSystemService.mod(adminSystem);
    }

    @Skip
    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage del(@RequestBody AdminSystemPara adminSystemPara) throws Exception{
        return adminSystemService.del(adminSystemPara);
    }
}
