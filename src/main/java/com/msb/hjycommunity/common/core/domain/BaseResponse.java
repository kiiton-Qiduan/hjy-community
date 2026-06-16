package com.msb.hjycommunity.common.core.domain;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 1180288907161900868L;

    private Integer code;

    private String msg;

    private T data;

    private boolean success;

    public static <T> BaseResponse<T> success(T data){
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResultCode.SUCCESS.getCode());
        response.setMsg(ResultCode.SUCCESS.getMessage());
        response.setSuccess(true);
        response.setData(data);

        return response;
    }

    public static <T> BaseResponse<T> fail(String message){
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResultCode.ERROR.getCode());
        response.setMsg(message);

        return response;
    }

    public static <T> BaseResponse<T> fail(Integer code,String message){
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg(message);

        return response;
    }

    public static <T> BaseResponse<T> fail(String code, String message,boolean success){

        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(Integer.parseInt(code));
        response.setMsg(message);
        response.setSuccess(success);
        return response;
    }
}
