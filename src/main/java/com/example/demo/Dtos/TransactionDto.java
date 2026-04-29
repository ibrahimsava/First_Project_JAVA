package com.example.demo.Dtos;

import com.example.demo.Enum.TypedeTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private Long id;
    private String referenceNumero;
    private TypedeTransaction typedeTransaction;
    private BigDecimal montant;
    private BigDecimal balanceBefore;
    private BigDecimal balanceAfter;
    private String description;
    private String targetNumerodeCompte;

    // On utilise l'ID ou le numéro du compte, pas l'objet Entity Compte
    private Long compteId;

    private LocalDateTime createdAt;
}
