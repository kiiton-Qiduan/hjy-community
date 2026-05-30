package com.msb.hjycommunity.common.core.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 7537554069519293667L;

    // 非数据库字段，仅用于搜索
    @TableField(exist = false)
    private String searchValue;

    // 请求参数
    @TableField(exist = false)
    private Map<String, Object> params;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private String remark;
}
