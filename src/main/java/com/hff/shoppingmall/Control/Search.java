package com.hff.shoppingmall.Control;

import com.hff.shoppingmall.Bean.Product;
import com.hff.shoppingmall.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/api")
public class Search {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/dashboard/getCommonidities", method = RequestMethod.GET)
    ArrayList<Map<String, Object>> getCommonidities () {
        List<Product> tmpList = productService.selectAllProduct();
        String[] categories = {"平板电视", "马桶", "电热水器", "沙发", "平衡车", "扫地机器人", "原汁机", "冰箱", "空调", "女表"};

        ArrayList<Map<String, Object>> result = new ArrayList<>();
        for (int i = 0; i < categories.length; i++) {
            HashMap<String, Object> tmp = new HashMap<>();
            tmp.put("category", categories[i]);
            ArrayList<Product> data = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                data.add(tmpList.get(i * 5 + j));
            }
            tmp.put("data", data);
            result.add(tmp);
        }
        return result;
    }

}



// for (int i = 0;i<tmpList.size();i++){
//        String image = tmpList.get(i).get("src");
//        String label = tmpList.get(i).get("label");
//        double price = Double.parseDouble(tmpList.get(i).get("price"));
//        System.out.println(image);
//        System.out.println(label);
//        System.out.println(price);
//
//        Product product = new Product();
//        product.setImage(image);
//        product.setLabel(label);
//        product.setPrice(price);
//        productService.insert(product);
//
//        }
