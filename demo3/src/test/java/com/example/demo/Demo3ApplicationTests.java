package com.example.demo;


import com.example.demo.Mapper.buyer_infoMapper;
import com.example.demo.Mapper.goods_infoMapper;
import com.example.demo.Mapper.order_detailMapper;
import com.example.demo.pojo.Order_detail;
import com.example.demo.prepareThing.uniqueOrderId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Demo3ApplicationTests {


    @Autowired
    private uniqueOrderId uniqueOrderID;
    @Autowired
    private uniqueOrderId uniqueOrderID1;
    @Test
    void coutbuyer(){
        long uniqueNum = uniqueOrderID.getUniqueNum();
        System.out.println(uniqueNum);
        long uniqueNum1 = uniqueOrderID1.getUniqueNum();
        System.out.println(uniqueNum1);
    }

}
