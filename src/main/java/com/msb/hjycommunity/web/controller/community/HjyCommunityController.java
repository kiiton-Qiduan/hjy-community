package com.msb.hjycommunity.web.controller.community;

import com.msb.hjycommunity.common.core.controller.BaseController;
import com.msb.hjycommunity.common.core.domain.BaseResponse;
import com.msb.hjycommunity.common.core.page.PageResult;
import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;
import com.msb.hjycommunity.community.service.HjyCommunityService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
public class HjyCommunityController extends BaseController {

    @Autowired
    private HjyCommunityService hjyCommunityService;

    @GetMapping("/list")
    public PageResult list(HjyCommunity hjyCommunity){

        startPage();
        List<HjyCommunityDto> list = hjyCommunityService.queryList(hjyCommunity);

        return getData(list);
    }

    @PostMapping
    public BaseResponse<Integer> add(@RequestBody HjyCommunity hjyCommunity) {
        return toAjax(hjyCommunityService.insertHjyCommunity(hjyCommunity));
    }

    @GetMapping("/{communityId}")
    public BaseResponse getInfo(@PathVariable("communityId") Long communityId){
        return BaseResponse.success(hjyCommunityService.selectHjyCommunityById(communityId));
    }

    @PutMapping
    private BaseResponse edit(@RequestBody HjyCommunity hjyCommunity){
        return toAjax(hjyCommunityService.edit(hjyCommunity));
    }

    @DeleteMapping("/{communityIds}")
    private BaseResponse delete(@PathVariable Long[] communityIds){
        return toAjax(hjyCommunityService.deleteHjyCommunity(communityIds));
    }
}
