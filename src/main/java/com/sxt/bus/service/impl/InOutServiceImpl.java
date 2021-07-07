package com.sxt.bus.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxt.bus.domain.InOutInfo;
import com.sxt.bus.mapper.InOutMapper;
import com.sxt.bus.service.InOutInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class InOutServiceImpl extends ServiceImpl<InOutMapper, InOutInfo> implements InOutInfoService {

    @Override
      public List<InOutInfo> selectAllInfo(InOutInfo inOutInfo){
        return this.baseMapper.getloadSelectInout(inOutInfo);
      }

  @Override
  public List<InOutInfo> selectInfoOperateperson(InOutInfo inOutInfo) {
    return this.baseMapper.getInfoOperateperson(inOutInfo);
  }

  @Override
  public List<InOutInfo> selectInfotime(InOutInfo inOutInfo) {
    return this.baseMapper.getInfotime(inOutInfo);
  }

  @Override
  public List<InOutInfo> selectInfotime2(InOutInfo inOutInfo) {
    return this.baseMapper.getInfotime2(inOutInfo);
  }

  @Override
      public Page<InOutInfo> findAllAndPage(Page<InOutInfo> page){
        return this.baseMapper.findAllAndPage(page);
      }

  @Override
  public List<InOutInfo> loadSelectAndPage(InOutInfo inOutInfo) {
    return this.baseMapper.getloadSelectInout(inOutInfo);
  }

  @Override
  public List<InOutInfo> selectAllInfo2(InOutInfo inOutInfo){
    return this.baseMapper.getAllInOutInfo(inOutInfo);
  }

  @Override
  public List<InOutInfo> selectState(InOutInfo inOutInfo) {
    return this.baseMapper.getSelectState(inOutInfo);
  }

}
