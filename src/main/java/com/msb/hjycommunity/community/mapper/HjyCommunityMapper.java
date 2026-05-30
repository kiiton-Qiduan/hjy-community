package com.msb.hjycommunity.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HjyCommunityMapper extends BaseMapper<HjyCommunity> {

    /**
     * 查询小区列表，且有输入地区时会根据地区进行查询
     * @param hjyCommunity
     * @return
     */
    public List<HjyCommunityDto> queryList(@Param("community") HjyCommunity hjyCommunity);

}
