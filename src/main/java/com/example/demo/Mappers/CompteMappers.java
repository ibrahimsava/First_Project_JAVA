package com.example.demo.Mappers;
import com.example.demo.Dtos.CompteDto;
import com.example.demo.Entitys.Compte;
import com.example.demo.Entitys.Utilisateur;


public class CompteMappers {

    public static Compte tdtoToCompte(CompteDto compteDto) {
        if (compteDto == null) {
            return null;
        }
        return Compte.builder()
                .id(compteDto.getId())
                .statutsduCompte(compteDto.getStatutsduCompte())
                .balance(compteDto.getBalance())
                .typedeCompte(compteDto.getTypedeCompte())
                .typedeTransaction(compteDto.getTypedeTransaction())
                .utilisateur(Utilisateur.builder().id(compteDto.getUtilisateurId()).build())
                .build();
    }

    public static CompteDto toEntityCompte(Compte compte) {
        if (compte == null) {
            return null;
        }
        return CompteDto.builder()
                .id(compte.getId())
                .statutsduCompte(compte.getStatutsduCompte())
                .balance(compte.getBalance())
                .typedeCompte(compte.getTypedeCompte())
                .typedeTransaction(compte.getTypedeTransaction())
                .utilisateurId(compte.getUtilisateur() != null ? compte.getUtilisateur().getId() : null)
                .build();
    }

}



