package com.msb.hjycommunity.common.core.exception;

import com.msb.hjycommunity.common.core.domain.BaseResponse;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse baseExceptionHandler(BaseException e){
        return BaseResponse.fail(e.getDefaultMessage());
    }

}
