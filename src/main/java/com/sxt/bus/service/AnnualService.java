package com.sxt.bus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sxt.bus.domain.Annual;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnnualService extends IService<Annual> {
    Page<Annual> findAllAnnual(Page<Annual> pageArt);

    List<Annual> selectState(Annual annual);

    Page<Annual> selectInfo(Page<Annual> pageArt);

    List<Annual> findAllAnnual2(Annual annual);

    Page<Annual> selectInfo2(Page<Annual> pageArt);
}
