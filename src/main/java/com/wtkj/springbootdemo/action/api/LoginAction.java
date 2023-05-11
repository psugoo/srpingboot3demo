package com.wtkj.springbootdemo.action.api;

import com.wtkj.springbootdemo.common.JsonResponse;
import com.wtkj.springbootdemo.entity.SysUser;
import com.wtkj.springbootdemo.service.LoginService;
import com.wtkj.springbootdemo.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author songyan
 * @since 2023年03月21日
 */
@RestController
@RequestMapping("demo/api")
public class LoginAction {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public JsonResponse login(String username , String password){


        SysUser user = loginService.login(username,password);


        if(Assert.notNull(user)){

            return JsonResponse.success(user);
        }

        else{
            return JsonResponse.fail("登录失败");
        }




    }

}
