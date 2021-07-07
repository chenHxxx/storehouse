package com.sxt.bus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxt.bus.domain.Apply;
import com.sxt.bus.mapper.ApplyMapper;
import com.sxt.bus.service.ApplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply> implements ApplyService {

    @Override
    public boolean save(Apply entity) {
        // TODO Auto-generated method stub
        return super.save(entity);

    }

    @Override
    public boolean updateById(Apply apply) {

        return super.updateById(apply);
    }
}
