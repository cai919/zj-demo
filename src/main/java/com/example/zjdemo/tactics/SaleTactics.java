package com.example.zjdemo.tactics;

import java.math.BigDecimal;

public interface SaleTactics {

    BigDecimal calc(BigDecimal price);

    String getTacticsName();

}
