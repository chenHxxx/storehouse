package com.sxt.bus.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.bus.domain.Annual;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.AnnualService;
import com.sxt.bus.service.GoodsService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.AnnualVo;
import com.sxt.sys.common.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Annual")
public class AnnualController {

    @Autowired
    AnnualService annualService;

    @Autowired
    ProviderService providerService;

    @Autowired
    GoodsService goodsService;

    /**
     * 查询
     */
    @RequestMapping("AnnualSelect")
    public DataGridView loadAllInOut(AnnualVo annualVo) {
        Page<Annual> pageArt=new Page<Annual>(annualVo.getPage(),annualVo.getLimit());
        Page<Annual> page1=this.annualService.findAllAnnual(pageArt);

        //  List<annual> list=this.annualService.selectAllInfo();
        List<Annual> list=page1.getRecords();
        for (Annual annual : list) {
            Provider provider = this.providerService.getById(annual.getProviderid());
            if(null!=provider) {
                annual.setProvidername(provider.getProvidername());
            }
            Goods goods = this.goodsService.getById(annual.getGoodsid());
            if(null!=goods) {
                annual.setGoodsname(goods.getGoodsname());
                annual.setSize(goods.getSize());
            }
        }

        return new DataGridView(pageArt.getTotal(),list);

    }


    @RequestMapping("loadSelectAnnual")
    public String loadSelectInOut(Annual annual) {
        Provider provider = new Provider();
        Goods goods = new Goods();
        if (annual.getProviderid() !=null && annual.getProviderid() !=0) {
            provider = this.providerService.getById(annual.getProviderid());
            if (null != provider) {
                annual.setProvidername(provider.getProvidername());
            }
        }
        if (annual.getGoodsid() !=null && annual.getGoodsid() !=0){
            goods = this.goodsService.getById(annual.getGoodsid());
            if (null != goods) {
                annual.setGoodsname(goods.getGoodsname());
            }
        }
        List<Annual> list= new ArrayList<Annual>();
        if (annual.getGoodsid() == null && annual.getProviderid() == 0 && annual.getStarttime() == "" && annual.getEndtime() == "" &&annual.getOperateperson() == "" && annual.getState() == null){
            list = this.annualService.findAllAnnual2(annual);
        }else{
        list = this.annualService.selectState(annual);
      }
//        if (annual.getState() == null && annual.getProviderid() == 0 && annual.getGoodsid() == 0 && StringUtils.isBlank(annual.getEndtime()) && StringUtils.isBlank(annual.getStarttime()) && StringUtils.isBlank(annual.getOperateperson())){
//            list = this.annualService.selectAllInfo2(annual);
//        }
        for (Annual annual1 : list){
                Provider provider1 = this.providerService.getById(annual1.getProviderid());
                if (null != provider) {
                    annual1.setProvidername(provider1.getProvidername());
                }
                Goods goods1 = this.goodsService.getById(annual1.getGoodsid());
                if (null != goods) {
                    annual1.setGoodsname(goods1.getGoodsname());
                    annual1.setSize(goods1.getSize());
                }


        }

        //   List<annual> list=page1.getRecords();
//        for (annual annual : list) {
//            Provider provider = this.providerService.getById(annual.getProviderid());
//            if(null!=provider) {
//                annual.setProvidername(provider.getProvidername());
//            }
//            Goods goods = this.goodsService.getById(annual.getGoodsid());
//            if(null!=goods) {
//                annual.setGoodsname(goods.getGoodsname());
//                annual.setSize(goods.getSize());
//            }
//        }
        System.out.println(list);
        JSONObject obj=new JSONObject();
        //前台通过key值获得对应的value值
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count",list.size());
        obj.put("data",list);
        String s = obj.toJSONString();

        return s;

    }

    @RequestMapping("ZhuZhuangCK")
    public DataGridView ZhuZhuangTuCK(AnnualVo annualVo) {
//
//        Provider provider = new Provider();
//        Goods goods = new Goods();
//        List<Annual> list= new ArrayList<Annual>();
//
//        list = this.annualService.selectInfo();
//
//        for (Annual annual1 : list){
//            Provider provider1 = this.providerService.getById(annual1.getProviderid());
//            if(null!=provider) {
//                annual1.setProvidername(provider1.getProvidername());
//            }
//            Goods goods1 = this.goodsService.getById(annual1.getGoodsid());
//            if(null!=goods) {
//                annual1.setGoodsname(goods1.getGoodsname());
//                annual1.setSize(goods1.getSize());
//            }
//
//        }
//
//        return list;
        Page<Annual> pageArt=new Page<Annual>(annualVo.getPage(),annualVo.getLimit());
        Page<Annual> page1=this.annualService.selectInfo(pageArt);

        //  List<annual> list=this.annualService.selectAllInfo();
        List<Annual> list=page1.getRecords();
        for (Annual annual : list) {
            Provider provider = this.providerService.getById(annual.getProviderid());
            if(null!=provider) {
                annual.setProvidername(provider.getProvidername());
            }
            Goods goods = this.goodsService.getById(annual.getGoodsid());
            if(null!=goods) {
                annual.setGoodsname(goods.getGoodsname());
                annual.setSize(goods.getSize());
            }
        }

        return new DataGridView(pageArt.getTotal(),list);

    }

    @RequestMapping("ZhuZhuangRK")
    public DataGridView ZhuZhuangTuRK(AnnualVo annualVo) {
        Page<Annual> pageArt=new Page<Annual>(annualVo.getPage(),annualVo.getLimit());
        Page<Annual> page1=this.annualService.selectInfo2(pageArt);
        List<Annual> list=page1.getRecords();
        for (Annual annual : list) {
            Provider provider = this.providerService.getById(annual.getProviderid());
            if(null!=provider) {
                annual.setProvidername(provider.getProvidername());
            }
            Goods goods = this.goodsService.getById(annual.getGoodsid());
            if(null!=goods) {
                annual.setGoodsname(goods.getGoodsname());
                annual.setSize(goods.getSize());
            }

        }

        return new DataGridView(pageArt.getTotal(),list);

    }
}