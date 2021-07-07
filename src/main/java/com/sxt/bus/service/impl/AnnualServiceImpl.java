package com.sxt.bus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxt.bus.domain.Annual;
import com.sxt.bus.mapper.AnnualMapper;
import com.sxt.bus.service.AnnualService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnnualServiceImpl extends ServiceImpl<AnnualMapper, Annual> implements AnnualService {
    @Override
    public Page<Annual> findAllAnnual(Page<Annual> pageArt) {
        return this.baseMapper.getAnnual(pageArt);
    }

    @Override
    public List<Annual> selectState(Annual annual) {
        return this.baseMapper.getselectState(annual);
    }

    @Override
    public Page<Annual> selectInfo(Page<Annual> pageArt) {
        return this.baseMapper.getSelectInfo(pageArt);
    }

    @Override
    public List<Annual> findAllAnnual2(Annual annual) {
        return this.baseMapper.findAllAnnual2(annual);
    }

    @Override
    public Page<Annual> selectInfo2(Page<Annual> pageArt) {
        return this.baseMapper.getSelectInfo2(pageArt);
    }
}
