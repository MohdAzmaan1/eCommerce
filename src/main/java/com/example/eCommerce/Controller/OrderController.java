package com.example.eCommerce.Controller;

import com.example.eCommerce.Model.Order;
import com.example.eCommerce.Model.OrderEntryDTO;
import com.example.eCommerce.Model.Product;
import com.example.eCommerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<String > placeOrder(@RequestBody OrderEntryDTO orderEntryDTO) throws Exception{
        return new ResponseEntity<>(orderService.placeOrder(orderEntryDTO), HttpStatus.CREATED);
    }
}
