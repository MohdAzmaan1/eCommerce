package com.example.eCommerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderId = UUID.randomUUID().toString();
    private int totalPrice;

    @Enumerated(value = EnumType.STRING)
    private PaymentMode paymentMode;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();
}
