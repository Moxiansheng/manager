package com.mo.manager.interceptor;

import com.mo.manager.annotations.PassToken;
import com.mo.manager.pojo.UserToken;
import com.mo.manager.util.ResponseResult;
import com.mo.manager.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

import static com.mo.manager.commons.CommonIntegers.INT_7;
import static com.mo.manager.commons.CommonStrings.HTTP_BEARER_TOKEN_PREFIX;
import static com.mo.manager.commons.CommonStrings.USER_TOKEN;
import static com.mo.manager.util.JsonRelated.writeResponseResult2Response;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
public class AuthorizationInterceptor implements HandlerInterceptor {

    /**
     * 现用DaoService
     * TODO 后转为RedisService
     *
     * 转为TokenUtil的使用
     */
//    @Autowired
//    InfoUserService userService;

    @Resource
    TokenUtil tokenUtil;

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 非方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        // 获取方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 有PassToken的注解就说明不需要进行Token验证，直接过
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }

        try{
            // 获取request中的token
            String token = request.getHeader(AUTHORIZATION).substring(INT_7);
            // token验证并更新
            UserToken userToken = tokenUtil.verify(token);
            // 将解析出的用户信息向后传递
            request.setAttribute(USER_TOKEN, userToken);
            return true;
        }catch (RuntimeException e){
            writeResponseResult2Response(response, ResponseResult.loginNeeded(e.toString()));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 将request中存放的userToken获取到
        UserToken userToken = (UserToken) request.getAttribute(USER_TOKEN);
        // 如果是非登出操作
        if(userToken != null){
            // 设置response中的token
            response.addHeader(AUTHORIZATION, HTTP_BEARER_TOKEN_PREFIX + userToken.getToken());
        }
    }
}
