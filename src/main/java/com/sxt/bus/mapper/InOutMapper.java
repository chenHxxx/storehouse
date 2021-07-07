package com.sxt.bus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.bus.domain.InOutInfo;
import com.sxt.bus.vo.InOutInfoVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface InOutMapper extends BaseMapper<InOutInfo> {


    Page<InOutInfo> findAllAndPage(Page<InOutInfo> page);

    @Select("select a.id,a.paytype,a.providerid,a.goodsid,a.inporttime,a.operateperson,a.number,a.state1 as state from bus_inport a \n" +
            "UNION all\n" +
            "select b.id,b.paytype,b.providerid,b.goodsid,b.outputtime,b.operateperson,b.number,b.state0 as state from bus_outport b\n")
    List<InOutInfo> getAllInOutInfo(InOutInfo inOutInfo);

    List<InOutInfo> getloadSelectInout(InOutInfo inOutInfo);

    List<InOutInfo> getInfoOperateperson(InOutInfo inOutInfo);

    List<InOutInfo> getInfotime(InOutInfo inOutInfo);

    List<InOutInfo> getInfotime2(InOutInfo inOutInfo);

    List<InOutInfo> getSelectState(InOutInfo inOutInfo);
}
