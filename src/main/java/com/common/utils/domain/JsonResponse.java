package com.common.utils.domain;

import java.io.Serializable;

/**
 * @author keven
 * @date 2018-01-17 下午6:25
 * @Description
 */
public class JsonResponse<T> implements Serializable{

    private static final long serialVersionUID = 1097790830784050940L;

    private T result;
    private Boolean success;
    private String error;

    public Boolean isSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setErrors(String errors) {
        this.success = false;
        this.error = errors;
    }

    public static <T> JsonResponse<T> ok(T data){
        JsonResponse<T> response = new JsonResponse<T>();
        response.setResult(data);
        return response;
    }

    public static <T> JsonResponse<T> fail(String error) {
        JsonResponse<T> response = new JsonResponse<T>();
        response.setErrors(error);
        return response;
    }


}
