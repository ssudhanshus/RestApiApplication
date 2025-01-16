package com.example.Bank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Bank.Entity.Customer;
import com.example.Bank.Entity.Transaction;
import com.example.Bank.Service.BankService;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer registeredCustomer = bankService.registerCustomer(customer);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId) {
        Customer customer = bankService.getCustomer(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customers/{customerId}/debit")
    public ResponseEntity<Transaction> debit(@PathVariable Long customerId,
                                            @RequestParam double amount,
                                            @RequestParam String description) {
        Transaction transaction = bankService.debit(customerId, amount, description);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/customers/{customerId}/credit")
    public ResponseEntity<Transaction> credit(@PathVariable Long customerId,
                                             @RequestParam double amount,
                                             @RequestParam String description) {
        Transaction transaction = bankService.credit(customerId, amount, description);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/customers/{customerId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionsByCriteria(
            @PathVariable Long customerId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount) {
        List<Transaction> transactions = bankService.getTransactionsByCriteria(
                customerId, type, minAmount, maxAmount);
        return ResponseEntity.ok(transactions);
    }
}
