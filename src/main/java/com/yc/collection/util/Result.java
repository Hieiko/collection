package com.yc.collection.util;

public class Result <T>{
    T Data;
    int Code;
    String Msg;

    public String getMsg() {
        return Msg;
    }

    public Result<T> setMsg(String msg) {
        Msg = msg;
        return this;
    }


    public T getData() {
        return Data;
    }

    public Result<T> setData(T data) {
        Data = data;
        return this;
    }

    public int getCode() {
        return Code;
    }

    public Result<T> setCode(int code) {
        Code = code;
        return this;
    }
}
