package com.msb.hjycommunity.community.service;

import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;

import java.util.List;

public interface HjyCommunityService {

    /**
     * 根据条件查询小区列表
     * @param hjyCommunity
     * @return
     */
    public List<HjyCommunityDto> queryList(HjyCommunity hjyCommunity);

    Integer insertHjyCommunity(HjyCommunity hjyCommunity);

    HjyCommunity selectHjyCommunityById(Long communityId);

    Integer edit(HjyCommunity hjyCommunity);

    Integer deleteHjyCommunity(Long[] communityId);
}
