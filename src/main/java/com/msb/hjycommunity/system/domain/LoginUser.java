package com.msb.hjycommunity.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.msb.hjycommunity.system.service.SysUserService;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * 登录用户
 */
@Data
public class LoginUser implements UserDetails {

    private SysUser sysUser;

    private String token;

    private Long loginTime;

    private Long expireTime;

    public LoginUser() {
    }

    public LoginUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUserName();
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
