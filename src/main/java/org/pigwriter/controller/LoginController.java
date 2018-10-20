package org.pigwriter.controller;

import com.alibaba.fastjson.JSON;
import org.pigwriter.dto.APITarget;
import org.pigwriter.dto.UserLogin;
import org.pigwriter.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class LoginController {

    private UserService userService;

    @CrossOrigin("http://localhost:8081")
    @RequestMapping(value = "/login", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(@ModelAttribute UserLogin userLogin) {
        boolean state = userService.verifyPassword(userLogin.toUser());
        APITarget apiTarget = new APITarget();
        if (state) {
            apiTarget.setData("go");
            apiTarget.setMessage("登录成功");
            apiTarget.setState(200);
        } else {
            apiTarget.setMessage("登录失败");
            apiTarget.setState(-1);
            apiTarget.setData("error");
        }
        return JSON.toJSONString(apiTarget);
    }

    public UserService getUserService() {
        return userService;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
