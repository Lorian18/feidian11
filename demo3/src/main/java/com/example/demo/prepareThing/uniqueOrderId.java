package com.example.demo.prepareThing;

import org.springframework.stereotype.Repository;

@Repository
public class uniqueOrderId {
    public long getUniqueNum(){
        long  timeNew =  System.currentTimeMillis()/ 1000; // 10位数的时间戳
        return timeNew;
    }
}
