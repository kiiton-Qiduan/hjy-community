package com.msb.hjycommunity.common.core.domain;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 1180288907161900868L;

    private Integer code;

    private String message;

    private T data;

    public static <T> BaseResponse<T> success(T data){
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResultCode.SUCCESS.getCode());
        response.setMessage(ResultCode.SUCCESS.getMessage());
        response.setData(data);

        return response;
    }

    public static <T> BaseResponse<T> fail(String message){
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResultCode.ERROR.getCode());
        response.setMessage(message);

        return response;
    }

    public static <T> BaseResponse<T> fail(Integer code,String message){
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMessage(message);

        return response;
    }
}
