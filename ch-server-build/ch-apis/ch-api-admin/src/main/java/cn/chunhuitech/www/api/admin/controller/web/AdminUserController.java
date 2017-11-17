package cn.chunhuitech.www.api.admin.controller.web;

import cn.chunhuitech.www.api.admin.model.AdminUserInfoBo;
import cn.chunhuitech.www.api.admin.model.AdminUserLoginParaBo;
import cn.chunhuitech.www.api.admin.model.AdminUserSearchBo;
import cn.chunhuitech.www.api.common.model.ErrorMessage;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserPara;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserRoleModel;
import cn.chunhuitech.www.api.admin.model.AdminUserLoginBo;
import cn.chunhuitech.www.api.admin.service.AdminUserService;
import cn.chunhuitech.www.api.common.constant.ConstantApi;
import cn.chunhuitech.www.api.common.model.Result;
import cn.chunhuitech.www.core.admin.model.cus.AdminUserSearchModel;
import cn.chunhuitech.www.core.admin.model.pojo.AdminRole;
import cn.chunhuitech.www.core.admin.model.pojo.AdminUser;
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


    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserSearchBo> search(@RequestBody AdminUserPara adminUserPara) throws Exception{
        return adminUserService.getList(adminUserPara);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage add(@RequestBody AdminUserSearchModel adminUserSearchModel) throws Exception{
        return adminUserService.add(adminUserSearchModel);
    }

    @RequestMapping(value = "/mod", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage mod(@RequestBody AdminUserSearchModel adminUserSearchModel) throws Exception{
        return adminUserService.mod(adminUserSearchModel);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public ErrorMessage del(@RequestBody AdminUserPara adminUserPara) throws Exception{
        return adminUserService.del(adminUserPara);
    }

    @RequestMapping(value = "/exist", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<Boolean> exist(@RequestBody AdminUserPara adminUserPara) throws Exception{
        return adminUserService.exist(adminUserPara);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, produces = ConstantApi.MEDIA_TYPE_APPLICATION_JSON)
    public Result<AdminUserSearchModel> get(@RequestBody AdminUserPara adminUserPara) throws Exception{
        return adminUserService.getModel(adminUserPara);
    }

}
