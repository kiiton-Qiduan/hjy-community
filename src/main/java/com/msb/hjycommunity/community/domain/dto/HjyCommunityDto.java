package com.msb.hjycommunity.community.domain.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.msb.hjycommunity.common.core.domain.BaseEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HjyCommunityDto extends BaseEntity {

    private static final long serialVersionUID = -7077915223985668982L;

    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long communityId;

    private String communityName;

    private String communityCode;

    private String communityProvinceCode;

    //省名称
    private String communityProvinceName;

    private String communityCityCode;

    //市名称
    private String communityCityName;

    private String communityTownCode;

    //区名称
    private String communityTownName;

    private String communityDetailAddress;

    private String communityLongitude;

    private String communityLatitude;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId;

    private Integer communitySort;
}
