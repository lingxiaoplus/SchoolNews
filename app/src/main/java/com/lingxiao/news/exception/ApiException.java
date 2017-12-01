package com.lingxiao.news.exception;

/**
 * Created by lingxiao on 17-11-29.
 * 异常处理类中，都是常见的错误类型，
 * 我们通过解析Throwable转换成统一的错误类ApiException
 */

public class ApiException extends Exception {
    private int code;//错误码
    private String msg;//错误信息

    public ApiException(Throwable throwable,int code){
        super(throwable);
        this.code = code;
    }

    public ApiException(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
