package com.example.demo.Mappers;

import com.example.demo.Dtos.TransactionDto;
import com.example.demo.Entitys.Compte;
import com.example.demo.Entitys.Transaction;
import com.example.demo.Enum.TypedeTransaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionMappers {

    public Transaction toTransactiondto(TransactionDto transactionDto) {
        if (transactionDto == null) {
            return null;

        }
        return Transaction.builder()
                .id(transactionDto.getId())
                .montant(transactionDto.getMontant())
                .typedeTransaction(transactionDto.getTypedeTransaction())
                .balanceAfter(transactionDto.getBalanceAfter())
                .balanceBefore(transactionDto.getBalanceBefore())
                .description(transactionDto.getDescription())
                .createdAt(transactionDto.getCreatedAt())
                .targetNumerodeCompte(transactionDto.getTargetNumerodeCompte())
                .compte(Compte.builder().id(transactionDto.getCompteId()).build())
                .build();

    }
    public TransactionDto toTransactionDto(Transaction transaction) {
        if (transaction == null) {
            return null;
        }

        return TransactionDto.builder()
                .id(transaction.getId())
                .montant(transaction.getMontant())
                .typedeTransaction(transaction.getTypedeTransaction())
                .balanceAfter(transaction.getBalanceAfter())
                .balanceBefore(transaction.getBalanceBefore())
                .description(transaction.getDescription())
                .createdAt(transaction.getCreatedAt())
                .targetNumerodeCompte(transaction.getTargetNumerodeCompte())
                .compteId(transaction.getCompte() != null ? transaction.getCompte().getId() : null)
                .build();
    }
}


