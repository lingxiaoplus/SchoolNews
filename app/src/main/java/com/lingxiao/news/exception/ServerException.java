package com.lingxiao.news.exception;

/**
 * Created by lingxiao on 17-11-29.
 * 跟服务器约定一种接口请求返回的数据
 */

public class ServerException extends RuntimeException{
    private int code;
    private String msg;

    public ServerException(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
