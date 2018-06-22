package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.AdminRoleInfoBo;
import cn.chunhuitech.www.api.admin.model.AdminRoleSearchBo;
import cn.chunhuitech.www.api.admin.service.AdminRoleService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.AdminRoleModel;
import cn.chunhuitech.www.core.admin.model.cus.AdminRolePara;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;
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
@RequestMapping(value = "/web/role")
public class AdminRoleController {


    @Autowired
    private AdminRoleService adminRoleService;


    @Skip
    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminRoleSearchBo> search(@RequestBody AdminRolePara adminRolePara) throws Exception{
        return adminRoleService.getList(adminRolePara);
    }

    @Skip
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage add(@RequestBody AdminRoleModel adminRoleModel) throws Exception{
        return adminRoleService.add(adminRoleModel);
    }

    @Skip
    @RequestMapping(value = "/mod", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage mod(@RequestBody AdminRoleModel adminRoleModel) throws Exception{
        return adminRoleService.mod(adminRoleModel);
    }

    @Skip
    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage del(@RequestBody AdminRolePara adminRolePara) throws Exception{
        return adminRoleService.del(adminRolePara);
    }

    @Skip
    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminRoleInfoBo> getRole(@RequestBody AdminRolePara adminRolePara) {
        return adminRoleService.getRole(adminRolePara);
    }
}
