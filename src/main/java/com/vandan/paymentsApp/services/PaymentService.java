package com.vandan.paymentsApp.services;

import com.vandan.paymentsApp.models.PaymentRequest;
import com.vandan.paymentsApp.models.TransactionStatus;
import com.vandan.paymentsApp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService{

    @Autowired
    private PaymentRepository paymentDBStore;
    private static int counter=1;

    public ResponseEntity<TransactionStatus> payToPerson(PaymentRequest paymentRequest){

        System.out.println(paymentRequest.getAmount());
        System.out.println(paymentDBStore.save(paymentRequest));
        TransactionStatus transactionStatus = new TransactionStatus(counter++, paymentRequest.getAmount(), "SUCCESS");
        return new ResponseEntity<TransactionStatus>(transactionStatus, HttpStatus.OK);
        //return true;
    }
}