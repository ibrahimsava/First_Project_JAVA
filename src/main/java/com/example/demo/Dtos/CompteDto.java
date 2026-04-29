package com.example.demo.Dtos;

import com.example.demo.Entitys.Transaction;
import com.example.demo.Enum.StatutsduCompte;
import com.example.demo.Enum.TypedeCompte;
import com.example.demo.Enum.TypedeTransaction;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteDto {

    Long id;

    private String NumerodeCompte; // format : BNK-20241201-0001
    private StatutsduCompte statutsduCompte;
    private BigDecimal balance;
    private TypedeCompte typedeCompte ;
    private TypedeTransaction typedeTransaction;
    private Long utilisateurId;
    private List<Transaction> transactions = new ArrayList<>();

}
