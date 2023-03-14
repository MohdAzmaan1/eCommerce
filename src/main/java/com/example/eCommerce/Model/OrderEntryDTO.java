package com.example.eCommerce.Model;

import lombok.Data;

@Data
public class OrderEntryDTO {

    private PaymentMode paymentMode;
    private int userId;
}
