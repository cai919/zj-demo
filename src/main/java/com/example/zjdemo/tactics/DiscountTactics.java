package com.example.zjdemo.tactics;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 折扣策略
 * 1. 打折券：提供一定的折扣，有9折优惠券。
 */
@Component
public class DiscountTactics implements SaleTactics {

    private static BigDecimal discount = new BigDecimal("0.9");

    @Override
    public BigDecimal calc(BigDecimal price) {
        if(price == null){
            throw new RuntimeException("价格异常");
        }
        return discount.multiply(price);
    }

    @Override
    public String getTacticsName() {
        return "Discount";
    }
}
