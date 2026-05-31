package com.msb.hjycommunity.community.service.impl;

import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;
import com.msb.hjycommunity.community.mapper.HjyCommunityMapper;
import com.msb.hjycommunity.community.service.HjyCommunityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HjyCommunityServiceImpl implements HjyCommunityService {

    @Autowired
    private HjyCommunityMapper hjyCommunityMapper;

    private static final String CODE_PREFIX = "COMMUNITY_";



    @Override
    public List<HjyCommunityDto> queryList(HjyCommunity hjyCommunity) {
        return hjyCommunityMapper.queryList(hjyCommunity);
    }

    @Override
    public Integer insertHjyCommunity(HjyCommunity hjyCommunity) {

        hjyCommunity.setCommunityCode(CODE_PREFIX+System.currentTimeMillis());

        return hjyCommunityMapper.insert(hjyCommunity);
    }

}
