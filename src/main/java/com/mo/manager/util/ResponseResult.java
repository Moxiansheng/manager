package com.mo.manager.util;

import java.util.HashMap;

public class ResponseResult extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";

    public static final String SUCCESS_INFO = "操作成功";
    public static final String FAIL_INFO = "操作成功";
    public static final String LOGIN_NEEDED_INFO = "需要登录";
    public static final String ERROR_INFO = "操作有误";

    /**
     * 状态类型
     */
    public enum Type
    {
        /** 成功 */
        SUCCESS(0),
        /**失败*/
        FAIL(1),
        /**未登录或登录失效*/
        LOGIN_NEEDED(1000),
        /** 警告 */
        WARN(301),
        /** 错误 */
        ERROR(500);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    /** 状态类型 */
    private Type type;

    /** 状态码 */
    private int code;

    /** 返回内容 */
    private String msg;

    /** 数据对象 */
    private Object data;

    /**
     * 初始化一个新创建的 ResponseResult 对象，使其表示一个空消息。
     */
    public ResponseResult()
    {
    }

    /**
     * 初始化一个新创建的 ResponseResult 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     */
    public ResponseResult(Type type, String msg)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 ResponseResult 对象
     *
     * @param type 状态类型
     * @param msg 返回内容
     * @param data 数据对象
     */
    public ResponseResult(Type type, String msg, Object data)
    {
        super.put(CODE_TAG, type.value);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static ResponseResult success()
    {
        return ResponseResult.success(SUCCESS_INFO);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResponseResult success(String msg)
    {
        return ResponseResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResponseResult success(String msg, Object data)
    {
        return new ResponseResult(Type.SUCCESS, msg, data);
    }

    /**
     * 返回失败消息
     *
     * @return 失败消息
     */
    public static ResponseResult fail()
    {
        return ResponseResult.fail(FAIL_INFO);
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @return 失败消息
     */
    public static ResponseResult fail(String msg)
    {
        return ResponseResult.fail(msg, null);
    }

    /**
     * 返回失败消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 失败消息
     */
    public static ResponseResult fail(String msg, Object data)
    {
        return new ResponseResult(Type.FAIL, msg, data);
    }

    /**
     * 返回未登录消息
     *
     * @return 未登录消息
     */
    public static ResponseResult loginNeeded()
    {
        return ResponseResult.loginNeeded(LOGIN_NEEDED_INFO);
    }

    /**
     * 返回未登录消息
     *
     * @param msg 返回内容
     * @return 未登录消息
     */
    public static ResponseResult loginNeeded(String msg)
    {
        return ResponseResult.loginNeeded(msg, null);
    }

    /**
     * 返回未登录消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 未登录消息
     */
    public static ResponseResult loginNeeded(String msg, Object data)
    {
        return new ResponseResult(Type.LOGIN_NEEDED, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResponseResult warn(String msg)
    {
        return ResponseResult.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResponseResult warn(String msg, Object data)
    {
        return new ResponseResult(Type.WARN, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static ResponseResult error()
    {
        return ResponseResult.error(ERROR_INFO);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResponseResult error(String msg)
    {
        return ResponseResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResponseResult error(String msg, Object data)
    {
        return new ResponseResult(Type.ERROR, msg, data);
    }

    public Type getType()
    {
        return type;
    }

    public void setType(Type type)
    {
        this.type = type;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }


}
