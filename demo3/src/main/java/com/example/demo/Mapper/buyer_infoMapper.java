package com.example.demo.Mapper;


import com.example.demo.pojo.Buyer_info;
import org.springframework.stereotype.Repository;

import java.util.List;


//加上这个注解表示了这是一个mybatis的mapper类
@Repository
public interface buyer_infoMapper {
    List<Buyer_info> getAllBuyer();
    String getNameById(int Id);
}
