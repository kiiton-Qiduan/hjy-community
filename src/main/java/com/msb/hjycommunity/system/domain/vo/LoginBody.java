package com.msb.hjycommunity.system.domain.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginBody {

    private String username;

    private String password;

    private String code;

    private String uuid;

}
