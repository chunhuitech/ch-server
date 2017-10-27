package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.AdminUserInfoBo;
import cn.chunhuitech.www.api.admin.model.AdminUserLoginParaBo;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;
import cn.chunhuitech.www.api.admin.model.AdminUserLoginBo;
import cn.chunhuitech.www.api.admin.service.AdminUserService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
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
    @RequestMapping(value = "/login2", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserLoginBo> login2(@RequestParam(value = "username") String userName,
                                          @RequestParam(value = "password") String passWord,
                                          HttpServletRequest request, HttpServletResponse response) throws Exception{
        return adminUserService.login(userName, passWord);
    }
//    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserLoginBo> login(@RequestBody AdminUserLoginParaBo adminUserLoginParaBo) throws Exception{
        return adminUserService.login(adminUserLoginParaBo.getUsername(), adminUserLoginParaBo.getPassword());
    }



    @RequestMapping(value = "/loginout", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<String> loginout() throws Exception{
        return adminUserService.loginout();
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserInfoBo> info(@RequestParam(value = "token") String token) throws Exception{
        return adminUserService.info(token);
    }





}
