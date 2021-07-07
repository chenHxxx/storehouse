package com.sxt.bus.controller;


import com.sxt.bus.domain.Approval;
import com.sxt.sys.common.AppFileUtils;
import com.sxt.sys.common.Constast;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.bus.domain.Apply;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.ApplyService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.ApplyVo;
import com.sxt.sys.common.DataGridView;
import com.sxt.sys.common.ResultObj;
import com.sxt.sys.vo.DeptVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bus")
public class ApplyController {

    @Autowired
    ApplyService applyService;

    @Autowired
    ProviderService providerService;


    /*
     * 商品添加申请
     * */
    @RequestMapping("addApply")
    @ResponseBody
    public ResultObj Apply(ApplyVo ApplyVo) {
        try {
            if (ApplyVo.getGoodsimg() != null && ApplyVo.getGoodsimg().endsWith("_temp")) {
                String newName = AppFileUtils.renameFile(ApplyVo.getGoodsimg());
                ApplyVo.setGoodsimg(newName);
            }
            this.applyService.save(ApplyVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 加载所有商品申请
     */
    @RequestMapping("loadAllapply")
    @ResponseBody
    public DataGridView loadAllGoods(ApplyVo applyVo) {
        IPage<Apply> page = new Page<>(applyVo.getPage(), applyVo.getLimit());
        QueryWrapper<Apply> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(applyVo.getProviderid() != null && applyVo.getProviderid() != 0, "providerid", applyVo.getProviderid());
        queryWrapper.like(StringUtils.isNotBlank(applyVo.getGoodsname()), "goodsname", applyVo.getGoodsname());
        queryWrapper.like(StringUtils.isNotBlank(applyVo.getProductcode()), "productcode", applyVo.getProductcode());
        queryWrapper.like(StringUtils.isNotBlank(applyVo.getDescription()), "description", applyVo.getDescription());
        queryWrapper.like(StringUtils.isNotBlank(applyVo.getSize()), "size", applyVo.getSize());
        if (applyVo.getApply() != null) {
            queryWrapper.like("apply", applyVo.getApply());
        } else {
            queryWrapper.between("apply", 0, 1);
        }
        this.applyService.page(page, queryWrapper);
        List<Apply> records = page.getRecords();
        for (Apply apply : records) {
            Provider provider = this.providerService.getById(apply.getProviderid());
            if (null != provider) {
                apply.setProvidername(provider.getProvidername());
            }
        }
        return new DataGridView(page.getTotal(), records);
    }

    /*
     * 删除商品申请
     * */
    @RequestMapping("deleteApply")
    @ResponseBody
    public ResultObj deleteApply(Integer id, String goodsimg) {
        try {
            //删除原文件
            AppFileUtils.removeFileByPath(goodsimg);
            this.applyService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /*
     * 更新申请
     * */
    @RequestMapping("updateApply")
    @ResponseBody
    public ResultObj updateApply(ApplyVo applyVo) {

        try {
            //说明是不默认图片
            if (!(applyVo.getGoodsimg() != null && applyVo.getGoodsimg().equals(Constast.IMAGES_DEFAULTGOODSIMG_PNG))) {
                if (applyVo.getGoodsimg().endsWith("_temp")) {
                    String newName = AppFileUtils.renameFile(applyVo.getGoodsimg());
                    applyVo.setGoodsimg(newName);
                    //删除原先的图片
                    String oldPath = this.applyService.getById(applyVo.getId()).getGoodsimg();
                    AppFileUtils.removeFileByPath(oldPath);
                }
            }
            applyVo.setApplytime(new Date());
            this.applyService.updateById(applyVo);
            return ResultObj.APPLY_UPDATESUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.APPLY_UPDATEERROR;
        }

    }

    /*
     * 商品申请
     * */
    @RequestMapping("goodApply")
    @ResponseBody
    public ResultObj goodApply(Apply apply) {
        apply.setApplytime(new Date());
        try {
            if (apply.getApply() == 0) {
                apply.setApply(1);
                this.applyService.updateById(apply);
            }
            return ResultObj.APPLY_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.APPLY_ERROR;
        }


    }
}
