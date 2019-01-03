package com.common.utils.exception;

/**
 * @author keven
 * @date 2018-04-30 下午10:12
 * @Description 业务异常
 */
public class ServiceException extends RuntimeException{


    private static final long serialVersionUID = -357076826800155498L;

    private int status = 500;

    private String message = "business exception";

    public ServiceException() {
    }

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ServiceException(int status, String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.status = status;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ServiceException(int status, Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
        this.status = status;
    }

    public ServiceException(Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
