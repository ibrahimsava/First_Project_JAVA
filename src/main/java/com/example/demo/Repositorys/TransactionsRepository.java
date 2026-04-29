package com.example.demo.Repositorys;

import com.example.demo.Entitys.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transaction, Long> {
}
