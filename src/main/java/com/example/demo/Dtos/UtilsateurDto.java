package com.example.demo.Dtos;

import com.example.demo.Enum.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UtilsateurDto {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String photo;
    private String adresse;
    private String telephone;
    private Role role ;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt; // on peut faire la mise a jour et ca sera toujours enregistrer
}
