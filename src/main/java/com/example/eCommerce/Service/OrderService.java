package com.example.eCommerce.Service;

import com.example.eCommerce.Model.Order;
import com.example.eCommerce.Model.OrderEntryDTO;
import com.example.eCommerce.Model.Product;
import com.example.eCommerce.Repository.OrderRepository;
import com.example.eCommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    public String placeOrder(OrderEntryDTO orderEntryDTO) throws Exception{
        Order order = new Order();
        List<Product> orderList = new ArrayList<>();
        List<Product> availableProductList = productRepository.findAll();
        int price = 0;
        for(Product product : availableProductList){
            if(product.getName().charAt(0) == 'A' || product.getName().charAt(0) == 'a'){
                orderList.add(product);
                product.setOrder(order);
                price += product.getPrice();
            }
        }
        if(orderList.size() == 0)
            throw new Exception("Product Not Found");

        order.setPaymentMode(orderEntryDTO.getPaymentMode());
        order.setProducts(orderList);
        order.setTotalPrice(price);
        orderRepository.save(order);
        return "Order Placed";
    }
}
