package com.example.demo.Mappers;

import com.example.demo.Dtos.UtilsateurDto;
import com.example.demo.Entitys.Utilisateur;


public class UtilisateursMappers {

    public static Utilisateur toDtoUtilisateur(UtilsateurDto utilsateurDto) {

        if (utilsateurDto == null) {
            return null;
        }
        return Utilisateur.builder()
                .id(utilsateurDto.getId())
                .nom(utilsateurDto.getNom())
                .prenom(utilsateurDto.getPrenom())
                .email(utilsateurDto.getEmail())
                .telephone(utilsateurDto.getTelephone())
                .createdAt(utilsateurDto.getCreatedAt())
                .updatedAt(utilsateurDto.getUpdatedAt())
                .role(utilsateurDto.getRole())
                .build();
    }


    public static UtilsateurDto toEntityUtilisateur(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }
        return UtilsateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .telephone(utilisateur.getTelephone())
                .createdAt(utilisateur.getCreatedAt())
                .updatedAt(utilisateur.getUpdatedAt())
                .role(utilisateur.getRole())
                .build();

    }
}
