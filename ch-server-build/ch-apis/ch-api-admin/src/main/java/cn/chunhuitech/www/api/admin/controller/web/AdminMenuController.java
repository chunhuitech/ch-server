package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.*;
import cn.chunhuitech.www.api.admin.service.AdminMenuService;
import cn.chunhuitech.www.api.admin.service.AdminUserService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.AdminMenuPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminMenu;
import cn.chunhuitech.www.core.common.annotation.Skip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hechengjin on 17-9-29.
 */
@RestController
@RequestMapping(value = "/web/menu")
public class AdminMenuController {

    @Autowired
    private AdminMenuService adminMenuService;

    @Skip
    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminMenuSearchBo> search(@RequestBody AdminMenuPara adminMenuPara) throws Exception{
        return adminMenuService.getList(adminMenuPara);
    }

    @Skip
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage add(@RequestBody AdminMenu adminMenu) throws Exception{
        return adminMenuService.add(adminMenu);
    }

    @Skip
    @RequestMapping(value = "/mod", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage mod(@RequestBody AdminMenu adminMenu) throws Exception{
        return adminMenuService.mod(adminMenu);
    }

    @Skip
    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage del(@RequestBody AdminMenuPara adminMenuPara) throws Exception{
        return adminMenuService.del(adminMenuPara);
    }


}
