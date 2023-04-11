package com.wtkj.springbootdemo.common;



/**
 * JSON格式类
 * Created by bin on 2017/2/20.
 */
public enum JsonCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    PARAMETER_INVALID(204, "参数不合法"),
    EXISTING(205, "已存在"),
    UNREGISTERED(206, "未注册"),
    TOKEN_NOT_FIND(207, "未找到"),
    OVERTIME(208, "已超时或过期"),
    EMPTY(209, "空数据"),
    PARAMETER_ERROR(210, "参数填写错误"),
    CONFLICT(211, "冲突"),
    BALANCE_NOT_ENOUGH(212, "余额不足"),
    NOT_AUTHORIZATION(213, "没有权限"),
    STATUS_DISABLED(214, "状态不可用"),
    STOP(215, "用户已被禁用"),
    NOT_TOKEN(400, "没有登录");

    JsonCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 代码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "";
    }

    /**
     * 判断是否是正确返回
     *
     * @param jsonCode 枚举
     * @return 是=true
     */
    public static boolean isSuccess(JsonCodeEnum jsonCode) {
        if (jsonCode != null) {
            if (jsonCode.equals(JsonCodeEnum.SUCCESS)) {
                return true;
            }
        }
        return false;
    }
    
   
}
