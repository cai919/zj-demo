package com.example.zjdemo.tactics;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 满减策略
 * 满减券：消费达到一定金额后可以减免一部分，有满5000减100。
 */
@Component
public class FullMinusTactics implements SaleTactics {

    private static BigDecimal minusThreshold = new BigDecimal("5000");
    private static BigDecimal minus = new BigDecimal("5000");

    @Override
    public BigDecimal calc(BigDecimal price) {
        if(price == null){
            throw new RuntimeException("单价有误");
        }
        return price.compareTo(minusThreshold) <= 0? price:price.subtract(minus);
    }

    @Override
    public String getTacticsName() {
        return "FullMinus";
    }
}
