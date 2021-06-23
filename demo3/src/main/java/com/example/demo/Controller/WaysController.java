package com.example.demo.Controller;

import com.example.demo.Mapper.buyer_infoMapper;
import com.example.demo.Mapper.goods_infoMapper;
import com.example.demo.Mapper.order_detailMapper;
import com.example.demo.Mapper.order_masterMapper;
import com.example.demo.pojo.Goods_info;
import com.example.demo.pojo.Order_detail;
import com.example.demo.pojo.Order_master;
import com.example.demo.prepareThing.uniqueOrderId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@RequestMapping("goods")
public class WaysController {
    @Autowired
    private goods_infoMapper goodsInfoMapper;
    @Autowired
    private buyer_infoMapper buyerInfoMapper;
    @Autowired
    private order_detailMapper orderDetailMapper;
    @Autowired
    private order_masterMapper orderMasterMapper;
    @Autowired
    private uniqueOrderId uniqueOrderiD;

    @PostMapping("/buy")
    public String buy(@RequestParam("buyer_id") int buyer_id,@RequestParam("buyer_address") String buyer_address,@RequestParam("good_id") int good_id,@RequestParam("good_quantity") int good_quantity){
        //生成order_master数据并储存
        long uniqueNum = uniqueOrderiD.getUniqueNum();
        System.out.println(buyer_id);
        System.out.println(buyer_address);
        System.out.println(good_id);
        System.out.println(good_quantity);
        boolean b = orderMasterMapper.setOrder(new Order_master(good_id, buyer_id, buyerInfoMapper.getNameById(buyer_id), buyer_address));
        if(b){
            int numById = goodsInfoMapper.getNumById(good_id);
            if(numById>good_quantity){
                boolean b1 = orderDetailMapper.setOrder(new Order_detail(uniqueNum, good_id, goodsInfoMapper.getNameById(good_id), goodsInfoMapper.getPriceById(good_id), good_quantity));
                if(b1){
                    System.out.println("订单生成成功");
                    return "Your order was successful";
                }else
                    System.out.println("订单生成失败");
                    return "Your order was failed";
            }else
                System.out.println("库存不足");
                return "Out of stock";
        }else
            System.out.println("订单生成失败");
            return "Your order was failed";
    }

    @GetMapping("/hi")
    public String hello(@RequestParam("sc") int sc){
        System.out.println("hello");
        return "hello 6666我的宝贝儿rld";
    }
    @PostMapping("/inventory")
    public String inventory(@RequestParam("good_id") int good_id,@RequestParam("good_minus") int good_minus){
        int numById = goodsInfoMapper.getNumById(good_id);
        if(good_minus>numById){
            System.out.println("错误");
            return "Out of stock";
        }else {
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("goods_inventory", numById-good_minus);
            map.put("goods_id", good_id);
            boolean b = goodsInfoMapper.updateNum(map);
            System.out.println("成功");
            return "Successful inventory reduction";
        }
    }
}
