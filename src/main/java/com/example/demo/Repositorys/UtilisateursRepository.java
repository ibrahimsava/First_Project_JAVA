package com.example.demo.Repositorys;

import com.example.demo.Entitys.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateursRepository extends JpaRepository<Utilisateur, Long> {
}
