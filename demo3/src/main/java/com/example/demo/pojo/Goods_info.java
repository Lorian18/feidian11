package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods_info {
    private int goods_id;
    private String goods_name;
    private float goods_price;
    private int goods_inventory;
}
