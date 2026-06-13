package com.msb.hjycommunity.community.domain.dto;

import cn.afterturn.easypoi.excel.annotation.*;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@ExcelTarget("community")
@Data
public class HjyCommunityExcelDto {
    /** 小区ID */
    @Excel(name = "序号")
    private Long communityId;

    /** 小区名称 */
    @Excel(name = "小区名称")
    private String communityName;

    /** 小区编码 */
    @Excel(name = "小区编码")
    private String communityCode;

    //省名称
    @Excel(name = "省")
    private String communityProvinceName;

    //市名称
    @Excel(name = "市")
    private String communityCityName;

    //区名称
    @Excel(name = "区/县")
    private String communityTownName;

    @Excel(name = "创建时间",exportFormat = "yyyy年MM月dd日")
    private Date createTime;

    @Excel(name = "备注")
    private String remark;
}
