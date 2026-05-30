package com.msb.hjycommunity.common.core.controller;

import com.github.pagehelper.*;
import com.msb.hjycommunity.common.constant.HttpStatus;
import com.msb.hjycommunity.common.core.page.*;
import com.msb.hjycommunity.common.utils.ServletUtils;

import java.util.List;

public class BaseController {

    //起一个安全名字
     public static final String PAGE_NUM = "pageNum";

     public static final String PAGE_SIZE = "pageSize";


    /**
     * 封装分页数据
     */

    public static PageDomain getPageDomain(){
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_NUM));
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PAGE_SIZE));

        return pageDomain;
    }

    protected void startPage(){

        PageDomain pageDomain = getPageDomain();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();

        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }

    }

    /**
     * 响应分页数据
     */
    protected PageResult getData(List<?> list){
        PageResult pageResult = new PageResult();
        pageResult.setCode(HttpStatus.SUCCESS);
        pageResult.setMsg("分页查询成功");
        pageResult.setRows(list);
        pageResult.setTotal(new PageInfo(list).getTotal());

        return pageResult;
    }
}
