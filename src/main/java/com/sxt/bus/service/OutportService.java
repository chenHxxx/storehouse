package com.sxt.bus.service;

import com.sxt.bus.domain.Outport;
import com.baomidou.mybatisplus.extension.service.IService;


public interface OutportService extends IService<Outport> {

	/**
	 * 退货
	 * @param id  进货单ID
	 * @param number  退货数量
	 * @param remark  备注
	 */
	void addOutPort(Integer id, Integer number, String remark);

}
