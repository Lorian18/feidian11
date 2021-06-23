package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_master {
    private int order_id;
    private int buyer_id;
    private String buyer_name;
    private String buyer_address;

}
