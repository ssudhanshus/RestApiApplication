package com.example.Bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.Bank.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

