package com.example.zjdemo.service;


import com.example.zjdemo.repository.pojo.Good;
import com.example.zjdemo.repository.pojo.GoodRepository;
import com.example.zjdemo.tactics.SaleTactics;
import com.example.zjdemo.tactics.TacticsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SaleService {

    @Autowired
    GoodRepository goodRepository;
    @Autowired
    TacticsManager tacticsManager;

    public BigDecimal getPrice(Long goodId, String tacticsName){
        SaleTactics tactics = tacticsManager.getTacticsByName(tacticsName);
        Good good = goodRepository.findGoodById(goodId);
        return tactics.calc(good.getPrice());
    }


}
