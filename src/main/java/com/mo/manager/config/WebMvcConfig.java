package com.mo.manager.config;

import com.mo.manager.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.mo.manager.commons.CommonIntegers.INT_3600;
import static com.mo.manager.commons.CommonStrings.*;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(new AuthorizationInterceptor())
                .addPathPatterns(ALL_PATH);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(ALL_PATH)                //设置了前端的地址
                .maxAge(INT_3600)
                .allowedOrigins(LOCALHOST_8080)
                .allowedMethods(HTTP_METHOD_GET,
                        HTTP_METHOD_POST,
                        HTTP_METHOD_DELETE,
                        HTTP_METHOD_PUT,
                        HTTP_METHOD_OPTIONS,
                        HTTP_METHOD_HEAD)
                .allowedHeaders(SINGLE_STAR)                //将请求头里保存的token暴露出来给前端获取
                .exposedHeaders(AUTHORIZATION);
    }
}
