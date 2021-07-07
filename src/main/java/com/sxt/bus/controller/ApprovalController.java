package com.sxt.bus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.bus.domain.Apply;
import com.sxt.bus.domain.Approval;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.ApprovalService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.ApplyVo;
import com.sxt.bus.vo.ApprovalVo;
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
public class ApprovalController {


    @Autowired
    ApprovalService approvalService;

    @Autowired
    ProviderService providerService;

    /*
     * 商品查询
     * */
    @RequestMapping("loadAllapproval")
    @ResponseBody
    public DataGridView loadAllGoods(ApprovalVo approvalVo) {
        IPage<Approval> page = new Page<>(approvalVo.getPage(), approvalVo.getLimit());
        QueryWrapper<Approval> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(approvalVo.getProviderid() != null && approvalVo.getProviderid() != 0, "providerid", approvalVo.getProviderid());
        queryWrapper.like(StringUtils.isNotBlank(approvalVo.getGoodsname()), "goodsname", approvalVo.getGoodsname());
        queryWrapper.like(StringUtils.isNotBlank(approvalVo.getProductcode()), "productcode", approvalVo.getProductcode());
        queryWrapper.like(StringUtils.isNotBlank(approvalVo.getPromitcode()), "promitcode", approvalVo.getPromitcode());
        queryWrapper.like(StringUtils.isNotBlank(approvalVo.getDescription()), "description", approvalVo.getDescription());
        queryWrapper.like(StringUtils.isNotBlank(approvalVo.getSize()), "size", approvalVo.getSize());
        if (approvalVo.getApply() != null){
            queryWrapper.like("apply",approvalVo.getApply());
        }else{
        queryWrapper.between("apply",1,2);
        }
        this.approvalService.page(page, queryWrapper);
        List<Approval> records = page.getRecords();
        for (Approval approval : records) {
            Provider provider = this.providerService.getById(approval.getProviderid());
            if (null != provider) {
                approval.setProvidername(provider.getProvidername());
            }
        }
        return new DataGridView(page.getTotal(), records);
    }

    /*
     * 商品审批
     * */
    @RequestMapping("updateApproval")
    @ResponseBody
    public ResultObj updateApply(Approval approval) {
        approval.setApprovaltime(new Date());
        try {
            if (approval.getApply() == 1) {
                approval.setApply(2);
                this.approvalService.updateById(approval);
                return ResultObj.APPROVAL_SUCCESS;
            }else if (approval.getApply() == 0) {
                return ResultObj.APPLY_APPROVAL;
            }else {
                return ResultObj.APPROVAL_ED;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.APPROVAL_ERROR;
        }
    }


    @RequestMapping("deleteApproval")
    @ResponseBody
    public ResultObj deleteApproval(Integer id,String goodsimg) {
        try {
            //删除原文件
            AppFileUtils.removeFileByPath(goodsimg);
            this.approvalService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
