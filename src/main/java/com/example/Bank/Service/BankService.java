package com.example.Bank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank.Entity.Customer;
import com.example.Bank.Entity.Transaction;
import com.example.Bank.Repository.CustomerRepository;
import com.example.Bank.Repository.TransactionRepository;

import java.util.List;

@Service
public class BankService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public Transaction debit(Long customerId, double amount, String description) {
        Customer customer = getCustomer(customerId);
        if (customer != null && customer.getBalance() >= amount) {
            customer.setBalance(customer.getBalance() - amount);
            Transaction transaction = new Transaction();
            transaction.setType("debit");
            transaction.setAmount(amount);
            transaction.setDescription(description);
            transaction.setCustomer(customer);
            customerRepository.save(customer); 
            return transactionRepository.save(transaction);
        }
        return null; 
    }

    public Transaction credit(Long customerId, double amount, String description) {
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            customer.setBalance(customer.getBalance() + amount);
            Transaction transaction = new Transaction();
            transaction.setType("credit");
            transaction.setAmount(amount);
            transaction.setDescription(description);
            transaction.setCustomer(customer);
            customerRepository.save(customer);
            return transactionRepository.save(transaction);
        }
        return null; 
    }

    public List<Transaction> getTransactionsByCriteria(Long customerId, String type, 
                                                     Double minAmount, Double maxAmount) {
        return transactionRepository.findTransactionsByCriteria(customerId, type, minAmount, maxAmount);
    }
}