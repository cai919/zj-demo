package com.example.zjdemo.tactics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class TacticsManager {

    @Autowired
    List<SaleTactics> tacticsList;

    public SaleTactics getTacticsByName(String tacticsName){
        if(!StringUtils.hasText(tacticsName)){
            throw new RuntimeException("策略异常");
        }

        for (SaleTactics saleTactics : tacticsList) {
            if(tacticsName.equals(saleTactics.getTacticsName())){
                return saleTactics;
            }
        }
        throw new RuntimeException("策略异常");
    }


}
