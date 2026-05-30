package com.msb.hjycommunity.community.service.impl;

import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;
import com.msb.hjycommunity.community.mapper.HjyCommunityMapper;
import com.msb.hjycommunity.community.service.HjyCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HjyCommunityServiceImpl implements HjyCommunityService {

    @Autowired
    private HjyCommunityMapper hjyCommunityMapper;

    @Override
    public List<HjyCommunityDto> queryList(HjyCommunity hjyCommunity) {
        return hjyCommunityMapper.queryList(hjyCommunity);
    }
}
