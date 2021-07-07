package com.sxt.bus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxt.bus.domain.Approval;
import com.sxt.bus.mapper.ApprovalMapper;
import com.sxt.bus.service.ApprovalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApprovalServiceImpl extends ServiceImpl<ApprovalMapper, Approval> implements ApprovalService {


    @Override
    public boolean updateById(Approval entity) {

        return super.updateById(entity);
    }
}
