package com.sxt.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/bus")
public class BusinessController {

	/**
	 * 跳转到客户管理
	 */
	@RequestMapping("toCustomerManager")
	public String toCustomerManager() {
		return "business/customer/customerManager";
	}
	/**
	 * 跳转到供应商管理
	 */
	@RequestMapping("toProviderManager")
	public String toProviderManager() {
		return "business/provider/providerManager";
	}
	/**
	 * 跳转到商品管理
	 */
	@RequestMapping("toGoodsManager")
	public String toGoodsManager() {
		return "business/goods/goodsManager";
	}
	/**
	 * 跳转到进货管理
	 */
	@RequestMapping("toInportManager")
	public String toInportManager() {
		return "business/inport/inportManager";
	}
	/**
	 * 跳转到退货查询管理
	 */
	@RequestMapping("toOutportManager")
	public String toOutportManager() {
		return "business/outport/outportManager";
	}
	/**
	 * 跳转到商品申请
	 */
	@RequestMapping("toApplyManager")
	public String toApplyManager() {
		return "business/Apply/ApplyManager";
	}
	/**
	 * 跳转到商品审批
	 */
	@RequestMapping("toApprovalManager")
	public String toApprovalManager() {
		return "business/Approval/ApprovalManager";
	}
	/**
	 * 跳转到商品采购
	 */
	@RequestMapping("toBuyManager")
	public String toBuyManager() {
		return "business/Buy/BuyManager";
	}
	/**
	 * 跳转到商品采购信息查询
	 */
	@RequestMapping("toBuyInfoManager")
	public String toGoodsInfoManager() {
		return "business/BuyInfo/BuyInfoManager";
	}

	/**
	 * 跳转到商品出入库查询
	 */
	@RequestMapping("toInOutInfoManager")
	public String toInOutInfoManager() {
		return "business/InOutInfo/InOutInfoManager";
	}

	/**
	 * 跳转到出入库年统计
	 */
	@RequestMapping("toAnnualManager")
	public String toAnnualManager() {
		return "business/Annual/AnnualManager";
	}

}
