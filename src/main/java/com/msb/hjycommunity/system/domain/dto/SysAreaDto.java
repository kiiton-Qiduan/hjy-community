package com.msb.hjycommunity.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysAreaDto implements Serializable {

    private static final long serialVersionUID = 7537554069519293667L;

    private Integer code;

    private String name;

    private Integer parentid;

    private List<SysAreaDto> children;
}
