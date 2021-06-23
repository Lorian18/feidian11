package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_detail {
    private long detail_id;
    private int order_id;
    private String goods_name;
    private float goods_price;
    private int goods_quantity;
}
