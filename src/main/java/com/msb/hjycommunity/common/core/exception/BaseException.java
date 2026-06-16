package com.msb.hjycommunity.common.core.exception;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseException extends RuntimeException{

    private Integer code;

    private String defaultMessage;

    public BaseException(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
