package com.msb.hjycommunity.common.core.domain;

import lombok.Getter;

@Getter
public enum ResultCode{

    SUCCESS(200,"操作成功"),
    ERROR(500,"操作失败");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
