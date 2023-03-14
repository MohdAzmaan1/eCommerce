package com.example.eCommerce.Controller;

import com.example.eCommerce.Model.Product;
import com.example.eCommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<String> getMaxPriceProduct(@RequestParam("category") String category) {
        return new ResponseEntity<>(productService.getMaxPriceProduct(category),HttpStatus.OK);
    }

    @GetMapping("/get-most-ordered")
    public ResponseEntity<String> getMostOrderedProduct(@RequestParam("category") String category) {
        return new ResponseEntity<>(productService.getMaxPriceProduct(category),HttpStatus.OK);
    }
}
