package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.*;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserInfoModel;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;
import cn.chunhuitech.www.api.admin.service.AdminUserService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
import cn.chunhuitech.www.core.common.annotation.Skip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hechengjin on 17-9-29.
 */
@RestController
@RequestMapping(value = "/web/user")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

//    @CrossOrigin
    @Skip
    @RequestMapping(value = "/login2", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserLoginBo> login2(@RequestParam(value = "username") String userName,
                                          @RequestParam(value = "password") String passWord,
                                          HttpServletRequest request, HttpServletResponse response) throws Exception{
        return adminUserService.login(userName, passWord);
    }


//    @CrossOrigin
    @Skip
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserLoginBo> login(@RequestBody AdminUserLoginParaBo adminUserLoginParaBo) throws Exception{
        return adminUserService.login(adminUserLoginParaBo.getUsername(), adminUserLoginParaBo.getPassword());
    }

    @Skip
    @RequestMapping(value = "/loginout", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<String> loginout() throws Exception{
        return adminUserService.loginout();
    }

    @Skip
    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserInfoBo> info(@RequestParam(value = "token") String token) throws Exception{
        return adminUserService.info(token);
    }

    @Skip
    @RequestMapping(value = "/baseInfo", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserInfoModel> getBaseInfo(@RequestParam(value = "token") String token) throws Exception{
        return adminUserService.getBaseInfo(token);
    }

    @Skip
    @RequestMapping(value = "/rightInfo", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminRightInfoBo> rightInfo(@RequestParam(value = "token") String token) throws Exception{
        return adminUserService.rightInfo(token);
    }

    @Skip
    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserSearchBo> search(@RequestBody AdminUserPara adminUserPara) throws Exception{
        return adminUserService.getList(adminUserPara);
    }

    @Skip
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage add(@RequestBody AdminUserSearchModel adminUserSearchModel) throws Exception{
        return adminUserService.add(adminUserSearchModel);
    }

    @Skip
    @RequestMapping(value = "/mod", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage mod(@RequestBody AdminUserSearchModel adminUserSearchModel) throws Exception{
        return adminUserService.mod(adminUserSearchModel);
    }

    @Skip
    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage del(@RequestBody AdminUserPara adminUserPara) throws Exception{
        return adminUserService.del(adminUserPara);
    }

    @Skip
    @RequestMapping(value = "/exist", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<Boolean> exist(@RequestBody AdminUserPara adminUserPara) throws Exception{
        return adminUserService.exist(adminUserPara);
    }

    @Skip
    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserSearchModel> get(@RequestBody AdminUserPara adminUserPara) throws Exception{
        return adminUserService.getModel(adminUserPara);
    }


    @Skip
    @RequestMapping(value = "/reset", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage reset(@RequestBody AdminUserPara adminUserPara) throws Exception{
        return adminUserService.reset(adminUserPara);
    }

}
