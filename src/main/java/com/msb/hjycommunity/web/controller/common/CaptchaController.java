package com.msb.hjycommunity.web.controller.common;

import com.msb.hjycommunity.common.constant.Constants;
import com.msb.hjycommunity.common.utils.*;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
public class CaptchaController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/captchaImage")
    public ChainedMap getCode(){
        SpecCaptcha specCaptcha = new SpecCaptcha(130,48,4);

        String uuid = UUIDUtils.simpleUUID();
        String key = Constants.CAPTCHA_CODE_KEY + uuid;

        String code = specCaptcha.text().toLowerCase();

        //放入redis
        redisTemplate.opsForValue().set(key,code, Duration.ofMinutes(10));

        return ChainedMap.create().set("uuid",uuid).set("img",specCaptcha.toBase64());
    }
}
