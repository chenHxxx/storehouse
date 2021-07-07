package com.sxt.bus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.bus.domain.Annual;

import java.util.List;

public interface AnnualMapper extends BaseMapper<Annual> {
    Page<Annual> getAnnual(Page<Annual> pageArt);

    List<Annual> getselectState(Annual annual);

    Page<Annual> getSelectInfo(Page<Annual> pageArt);

    List<Annual> findAllAnnual2(Annual annual);

    Page<Annual> getSelectInfo2(Page<Annual> pageArt);

}
