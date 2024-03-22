package com.xks.controller;

import com.xks.entity.Rate;
import com.xks.enums.AppHttpCodeEnum;
import com.xks.service.RateService;
import com.xks.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/rates")
public class RateController {
    @Autowired
    private RateService rateService;

    @GetMapping("/info")
    public ResponseResult queryInfo(){
        try {
            List<Rate> rates =rateService.queryAllRateInfo();
            return ResponseResult.okResult(rates);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.errorResult(AppHttpCodeEnum.ERROR);
        }
    }
}
