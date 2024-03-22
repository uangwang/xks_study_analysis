package com.xks.service.impl;
import java.util.List;
import com.xks.entity.Rate;
import com.xks.mapper.RateMapper;
import com.xks.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceimpl implements RateService {
    @Autowired
    private RateMapper rateMapper;

    @Override
    public List<Rate> queryAllRateInfo() {
        return rateMapper.queryAllRateInfo();
    }
}
