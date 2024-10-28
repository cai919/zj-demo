package com.example.zjdemo.repository.pojo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class GoodRepository {

    static Map<Long, Good> db = new HashMap<>();

    static {
        Good good = new Good();
        good.setId(1L);
        good.setGoodName("笔记本");
        good.setPrice(new BigDecimal("5000"));
        db.put(good.getId(), good);
    }

    public Good findGoodById(Long id){
        return Optional.of(db.get(id)).orElseThrow(() -> new RuntimeException("商品不存在"));
    }
}
