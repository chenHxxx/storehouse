package com.sxt.bus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sxt.bus.domain.InOutInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InOutInfoService extends IService<InOutInfo> {

    Page<InOutInfo> findAllAndPage(Page<InOutInfo> page);

    List<InOutInfo> loadSelectAndPage(InOutInfo inOutInfo);
    
    List<InOutInfo> selectAllInfo(InOutInfo inOutInfo);

    List<InOutInfo> selectInfoOperateperson(InOutInfo inOutInfo);

    List<InOutInfo> selectInfotime(InOutInfo inOutInfo);

    List<InOutInfo> selectInfotime2(InOutInfo inOutInfo);

    List<InOutInfo> selectAllInfo2(InOutInfo inOutInfo);


    List<InOutInfo> selectState(InOutInfo inOutInfo);
}
