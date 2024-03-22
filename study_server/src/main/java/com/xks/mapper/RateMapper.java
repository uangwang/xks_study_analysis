package com.xks.mapper;

import com.xks.entity.Rate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RateMapper {
    //用于获取信息
    List<Rate> queryAllRateInfo();
}
