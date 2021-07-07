package com.sxt.bus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.bus.domain.Approval;
import com.sxt.bus.domain.Buy;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.BuyService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.BuyVo;
import com.sxt.sys.common.AppFileUtils;
import com.sxt.sys.common.DataGridView;
import com.sxt.sys.common.ResultObj;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bus")
public class BuyInfoController {


    @Autowired
    BuyService buyService;

    @Autowired
    ProviderService providerService;

    /*
     * 商品查询
     * */
    @RequestMapping("loadAllbuyInfo")
    @ResponseBody
    public DataGridView loadAllGoodsInfo(BuyVo buyVo) {
        IPage<Buy> page = new Page<>(buyVo.getPage(), buyVo.getLimit());
        QueryWrapper<Buy> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(buyVo.getProviderid() != null && buyVo.getProviderid() != 0, "providerid", buyVo.getProviderid());
        queryWrapper.like(StringUtils.isNotBlank(buyVo.getGoodsname()), "goodsname", buyVo.getGoodsname());
        queryWrapper.like(StringUtils.isNotBlank(buyVo.getProductcode()), "productcode", buyVo.getProductcode());
        queryWrapper.like(StringUtils.isNotBlank(buyVo.getPromitcode()), "promitcode", buyVo.getPromitcode());
        queryWrapper.like(StringUtils.isNotBlank(buyVo.getDescription()), "description", buyVo.getDescription());
        queryWrapper.like(StringUtils.isNotBlank(buyVo.getSize()), "size", buyVo.getSize());
        if (buyVo.getApply() != null){
            queryWrapper.like("apply",buyVo.getApply());
        }else{
            queryWrapper.between("apply",0,4);
        }
        this.buyService.page(page, queryWrapper);
        List<Buy> records = page.getRecords();
        for (Buy buy : records) {
            Provider provider = this.providerService.getById(buy.getProviderid());
            if (null != provider) {
                buy.setProvidername(provider.getProvidername());
            }
        }
        return new DataGridView(page.getTotal(), records);
    }
}