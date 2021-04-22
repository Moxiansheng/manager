package com.mo.manager.controller;

import com.mo.manager.DiyException.LoginDBVerifyFailedException;
import com.mo.manager.annotations.PassToken;
import com.mo.manager.pojo.UserToken;
import com.mo.manager.service.InfoUserService;
import com.mo.manager.util.ResponseResult;
import com.mo.manager.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static com.mo.manager.commons.CommonStrings.*;

@RestController
public class LoginController {
    @Autowired
    InfoUserService infoUserService;

    @Resource
    TokenUtil tokenUtil;

    @PassToken
    @RequestMapping("/user/login")
    public ResponseResult login(@RequestBody Map<String, String> user,
                        HttpServletRequest request){
        try{
            // 数据库校验账号密码，并返回校验成功的用户id
            Integer id = infoUserService.getUserIdByLogin(user);
            // 根据id生成token并存入Redis
            UserToken userToken = tokenUtil.generate(id);
            // 将userToken传递给postHandle以便设置http头
            request.setAttribute(USER_TOKEN, userToken);
            // 返回成功状态
            return ResponseResult.success(EMPTY_STRING, id);
        } catch (LoginDBVerifyFailedException e){
            // 账号密码验证失败，返回失败状态
            return ResponseResult.fail(e.toString());
        }
    }

    @RequestMapping("/user/logout")
    public ResponseResult logout(@RequestBody Map<String, String> param,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        // 获取用户信息
        UserToken userToken = (UserToken) request.getAttribute(USER_TOKEN);
        // 通过user服务，向数据库记录登出记录

        // 摧毁request中包含的userToken信息，以便后续不返回token
        request.removeAttribute(USER_TOKEN);

        return ResponseResult.success(RES_MSG_LOGOUT_SUCCESS);
    }
}
