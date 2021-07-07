package com.sxt.bus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sxt.bus.domain.Buy;
import com.sxt.bus.mapper.BuyMapper;
import com.sxt.bus.service.BuyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BuyServiceImpl extends ServiceImpl<BuyMapper, Buy> implements BuyService {


}
