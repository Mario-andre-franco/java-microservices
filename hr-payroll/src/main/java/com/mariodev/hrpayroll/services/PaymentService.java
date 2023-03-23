package com.mariodev.hrpayroll.services;


import com.mariodev.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    public Payment getPayment(long workerId, int days) {
        return new Payment("Papai",200.0,days);
    }
}
