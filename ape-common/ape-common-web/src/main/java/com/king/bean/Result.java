package com.king.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {


    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回值信息
     */
    private String message;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 封装的数据
     */
    private T data;


    public static Result ok() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        return result;
    }

    public static Result ok(Integer resultCode, String resultMessage) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        return result;
    }

    public static <T> Result ok(Integer resultCode, String resultMessage, T data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        result.setData(data);
        return result;
    }

    public static <T> Result ok(T data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        return result;
    }

    public static Result fail(Integer resultCode, String resultMessage) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        return result;
    }

    public static <T> Result fail(Integer resultCode, String resultMessage, T data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        result.setData(data);
        return result;
    }

    public static <T> Result fail(T data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        result.setData(data);
        return result;
    }


}
