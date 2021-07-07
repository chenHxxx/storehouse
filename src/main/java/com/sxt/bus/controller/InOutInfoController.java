package com.sxt.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.bus.domain.*;
import com.sxt.bus.mapper.InOutMapper;
import com.sxt.bus.service.GoodsService;
import com.sxt.bus.service.InOutInfoService;
import com.sxt.bus.service.OutportService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.InOutInfoVo;
import com.sxt.bus.vo.OutportVo;
import com.sxt.sys.common.DataGridView;
import com.sxt.sys.common.ResultObj;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("InOut")
public class InOutInfoController {

    @Autowired
    private OutportService outportService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private InOutInfoService inOutInfoService;

    /**
     * 查询
     */
    @RequestMapping("loadAllInOut")
    public DataGridView loadAllInOut(InOutInfoVo inOutInfoVo) {
        Page<InOutInfo> pageArt=new Page<InOutInfo>(inOutInfoVo.getPage(),inOutInfoVo.getLimit());
        Page<InOutInfo> page1=this.inOutInfoService.findAllAndPage(pageArt);

      //  List<InOutInfo> list=this.inOutInfoService.selectAllInfo();
        List<InOutInfo> list=page1.getRecords();
        for (InOutInfo inOutInfo : list) {
            Provider provider = this.providerService.getById(inOutInfo.getProviderid());
            if(null!=provider) {
                inOutInfo.setProvidername(provider.getProvidername());
            }
            Goods goods = this.goodsService.getById(inOutInfo.getGoodsid());
            if(null!=goods) {
                inOutInfo.setGoodsname(goods.getGoodsname());
                inOutInfo.setSize(goods.getSize());
            }
        }

        return new DataGridView(pageArt.getTotal(),list);
    }

    @RequestMapping("loadSelectInOut")
    public String loadSelectInOut(InOutInfo inOutInfo) {

//        Page<InOutInfo> pageArt2=new Page<InOutInfo>(inOutInfoVo.getPage(),inOutInfoVo.getLimit());
//        Page<InOutInfo> page1=this.inOutInfoService.findAllAndPage(pageArt2);
        Provider provider = new Provider();
        Goods goods = new Goods();
        if (inOutInfo.getProviderid() != null && inOutInfo.getProviderid() != 0) {
            provider = this.providerService.getById(inOutInfo.getProviderid());
            if (null != provider) {
                inOutInfo.setProvidername(provider.getProvidername());
            }
        }
        if (inOutInfo.getGoodsid() !=null && inOutInfo.getGoodsid() != 0){
            goods = this.goodsService.getById(inOutInfo.getGoodsid());
            if (null != goods) {
                inOutInfo.setGoodsname(goods.getGoodsname());
            }
        }
        List<InOutInfo> list= new ArrayList<InOutInfo>();
            list = this.inOutInfoService.selectState(inOutInfo);
        for (InOutInfo inOutInfo1 : list){
            Provider provider1 = this.providerService.getById(inOutInfo1.getProviderid());
            if(null!=provider) {
                inOutInfo1.setProvidername(provider1.getProvidername());
            }
            Goods goods1 = this.goodsService.getById(inOutInfo1.getGoodsid());
            if(null!=goods) {
                inOutInfo1.setGoodsname(goods1.getGoodsname());
                inOutInfo1.setSize(goods1.getSize());
            }

        }
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

}
