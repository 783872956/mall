package com.hff.shoppingmall.Service;

import com.hff.shoppingmall.Bean.Order;
import com.hff.shoppingmall.Bean.OrderAddress;
import com.hff.shoppingmall.Bean.OrderProduct;
import com.hff.shoppingmall.dao.order.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public int insertOrder(com.hff.shoppingmall.dto.order.Order order) {

        Order orderSchema = createOrder(order);

        saveOrderAddress(order, orderSchema);

        batchInsertOrderProduct(order, orderSchema);

        return 1;
    }

    private void batchInsertOrderProduct(com.hff.shoppingmall.dto.order.Order order, Order orderSchema) {
        OrderProduct orderProduct = null;
        com.hff.shoppingmall.dto.order.OrderProduct item = null;
        for (int i = 0; i < order.getProductList().size(); i++) {
            item = order.getProductList().get(i);
            orderProduct = new OrderProduct();
            orderProduct.setPrice(item.getPrice());
            orderProduct.setOrderId(orderSchema.getOrderId());
            orderProduct.setProductID(item.getProductID());
            orderProduct.setCount(item.getCount());
            orderDao.insertOrderProduct(orderProduct);
        }
    }

    private void saveOrderAddress(com.hff.shoppingmall.dto.order.Order order, Order orderSchema) {
        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setAddress(order.getOrderAddress().getAddress());
        orderAddress.setPostalCode(order.getOrderAddress().getPostalCode());
        orderAddress.setName(order.getOrderAddress().getName());
        orderAddress.setPhone(order.getOrderAddress().getPhone());
        orderAddress.setOrderId(orderSchema.getOrderId());
        orderDao.insertOrderAddress(orderAddress);
    }

    private Order createOrder(com.hff.shoppingmall.dto.order.Order order) {
        Order orderSchema = new Order();
        orderSchema.setUserName(order.getUserName());
        Double totalPrice = 0.0;
        for (int i = 0; i < order.getProductList().size(); i++) {
//            totalPrice += order.getProductList().get(i).price;
            totalPrice += order.getProductList().get(i).price*order.getProductList().get(i).count;
        }
        orderSchema.setTotalPrice(totalPrice);
        orderDao.insertOrder(orderSchema);
        return orderSchema;
    }

    public Order selectEachOrder(Integer userName) {
        return orderDao.selectEachOrder(userName);
    }

}
