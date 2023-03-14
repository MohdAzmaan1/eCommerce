package com.example.eCommerce.Service;

import com.example.eCommerce.Model.Product;
import com.example.eCommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String addProduct(Product product) {
        productRepository.save(product);
        return "Product Added Successfully";
    }

    public String getMaxPriceProduct(String category) {
        List<Product> productList = productRepository.findAll();
        int price = 0;
        String name = "";
        Product product1 = new Product();
        for(Product product : productList) {
            if(product.getCategory().equals(category) && product.getPrice() > price){
                price = product.getPrice();
                name = product.getName();
            }
        }
        return name;
    }
}
