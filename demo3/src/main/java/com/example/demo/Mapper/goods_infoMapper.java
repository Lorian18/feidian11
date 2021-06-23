package com.example.demo.Mapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface goods_infoMapper {
    String getNameById(int goods_id);
    float getPriceById(int goods_id);
    int getNumById(int goods_id);
    boolean updateNum(Map<String,Object> map);
}
