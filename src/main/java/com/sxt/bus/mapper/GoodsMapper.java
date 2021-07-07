package com.sxt.bus.mapper;

import com.sxt.bus.domain.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sxt.bus.vo.GoodsVo;
import com.sxt.bus.vo.InportVo;

import java.util.List;


public interface GoodsMapper extends BaseMapper<Goods> {

    void updateByInport(InportVo inportVo);

    Goods getByName(GoodsVo goodsVo);

    List<Goods> loadSeriesGoods(Goods goods);

    List<Goods> loadChairGoods(Goods goods);

    List<Goods> loadSofaGoods(Goods goods);

    List<Goods> loadTaiGoods(Goods goods);

    List<Goods> loadBedGoods(Goods goods);
}
