package com.sxt.bus.service.impl;

import com.sxt.bus.domain.Goods;
import com.sxt.bus.mapper.GoodsMapper;
import com.sxt.bus.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.io.Serializable;
import java.util.List;

import com.sxt.bus.vo.GoodsVo;
import com.sxt.bus.vo.InportVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

	
	@Override
	public boolean save(Goods entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}
	
	@Override
	public boolean updateById(Goods entity) {
		// TODO Auto-generated method stub
		return super.updateById(entity);
	}
	
	@Override
	public boolean removeById(Serializable id) {
		// TODO Auto-generated method stub
		return super.removeById(id);
	}
	
	@Override
	public Goods getById(Serializable id) {
		// TODO Auto-generated method stub
		return super.getById(id);
	}

	@Override
	public void updateByInport(InportVo inportVo) {
	}

	@Override
	public Goods getByName(GoodsVo goodsVo) {
		return this.baseMapper.getByName(goodsVo);
	}

	@Override
	public List<Goods> loadSeriesGoods(Goods goods) {
		return this.baseMapper.loadSeriesGoods(goods);
	}

	@Override
	public List<Goods> loadChairGoods(Goods goods) {
		return this.baseMapper.loadChairGoods(goods);
	}

	@Override
	public List<Goods> loadSofaGoods(Goods goods) {
		return this.baseMapper.loadSofaGoods(goods);
	}

	@Override
	public List<Goods> loadTaiGoods(Goods goods) {
		return this.baseMapper.loadTaiGoods(goods);
	}

	@Override
	public List<Goods> loadBedGoods(Goods goods) {
		return this.baseMapper.loadBedGoods(goods);
	}
}
