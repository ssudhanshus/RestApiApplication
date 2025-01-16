package com.example.Bank.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Bank.Entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE t.customer.id = :customerId " +
            "AND t.type = :type AND t.amount >= :minAmount AND t.amount <= :maxAmount")
    List<Transaction> findTransactionsByCriteria(@Param("customerId") Long customerId,
                                               @Param("type") String type,
                                               @Param("minAmount") Double minAmount,
                                               @Param("maxAmount") Double maxAmount);
}
