package com.msb.hjycommunity.common.core.page;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResult implements Serializable {

    private static final long serialVersionUID = 7537554069519293667L;

    private Long total;

    //列表数据
    private List<?> rows;

    //消息状态码
    private Integer code;

    private String msg;

    public PageResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }
}
