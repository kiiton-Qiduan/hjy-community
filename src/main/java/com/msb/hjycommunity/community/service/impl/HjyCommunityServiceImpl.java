package com.msb.hjycommunity.community.service.impl;

import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;
import com.msb.hjycommunity.community.domain.vo.HjyCommunityVo;
import com.msb.hjycommunity.community.mapper.HjyCommunityMapper;
import com.msb.hjycommunity.community.service.HjyCommunityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public HjyCommunity selectHjyCommunityById(Long communityId) {
        return hjyCommunityMapper.selectById(communityId);
    }

    @Override
    public Integer edit(HjyCommunity hjyCommunity) {
        return hjyCommunityMapper.updateById(hjyCommunity);
    }

    @Override
    public Integer deleteHjyCommunity(Long[] communityId) {
        return hjyCommunityMapper.deleteBatchIds(Arrays.asList(communityId));
    }

    @Override
    public List<HjyCommunityVo> queryPullDown(HjyCommunity hjyCommunity) {
        // 1. 查出 Dto 列表
        List<HjyCommunityDto> dtoList = hjyCommunityMapper.queryList(hjyCommunity);

        // 2. 通过 Stream 流，把每一个 Dto 映射（map）成 Vo
        List<HjyCommunityVo> voList = dtoList.stream().map(dto -> {
            HjyCommunityVo vo = new HjyCommunityVo(); // 拿出一个空碗

            // 一对一拷贝
            BeanUtils.copyProperties(dto, vo);

            return vo;
        }).collect(Collectors.toList()); // 打包成 List

        return voList;
    }


}
