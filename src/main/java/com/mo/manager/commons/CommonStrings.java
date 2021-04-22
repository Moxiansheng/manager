package com.mo.manager.commons;

public class CommonStrings {
    /**
     * Special String
     */
    public static final String EMPTY_STRING = "";

    /**
     * Path Related
     */
    public static final String ALL_PATH = "/**";

    /**
     * URL Related
     */
    public static final String LOCALHOST_8080 = "http://localhost:8080";

    /**
     * HTTP Related
     */
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";
    public static final String HTTP_METHOD_DELETE = "DELETE";
    public static final String HTTP_METHOD_PUT = "PUT";
    public static final String HTTP_METHOD_OPTIONS = "OPTIONS";
    public static final String HTTP_METHOD_HEAD = "HEAD";

    public static final String HTTP_BEARER_TOKEN_PREFIX = "Bearer ";

    /**
     * Symbol Related
     */
    public static final String SINGLE_STAR = "*";

    /**
     * Self Equal
     */
    public static final String USER_TOKEN = "userToken";

    /**
     * Exception Related
     */
    public static final String AUTHORIZATION_EMPTY_EXCEPTION = "登陆凭证为空,请登录！";
    public static final String AUTHORIZATION_EXPIRED_EXCEPTION = "登陆凭证过期,请重新登录！";
    public static final String AUTHORIZATION_INVALID_EXCEPTION = "登陆凭证无效,请登录！";
    public static final String LOGIN_DB_VERIFY_FAILED_EXCEPTION = "用户名或密码有误！";

    /**
     * Pojo Field
     */
    public static final String POJO_GMT_CREATE = "gmtCreate";
    public static final String POJO_GMT_MODIFIED = "gmtModified";

    /**
     * Response Message
     */
    public static final String RES_MSG_LOGOUT_SUCCESS = "登出成功";
}
