package com.common.utils.base;

/**
 * @author keven
 * @date 2018-04-30 下午11:33
 * @Description
 */
public class JsonResult {

    private Object result;
    private String message;
    private Integer code = 0;

    public JsonResult() {
    }

    public JsonResult(Object result) {
        this.result = result;
    }

    public JsonResult(Object result, String message) {
        this.result = result;
        this.message = message;
    }

    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static JsonResult error() {
        return new JsonResult(false);
    }

    public static JsonResult error(String message) {
        return new JsonResult(false, message);
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
