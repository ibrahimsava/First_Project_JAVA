package com.example.demo.Entitys;

import com.example.demo.Enum.StatutsduCompte;
import com.example.demo.Enum.TypedeCompte;
import com.example.demo.Enum.TypedeTransaction;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comptes")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String NumerodeCompte; // format : BNK-20241201-0001

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private StatutsduCompte statutsduCompte = StatutsduCompte.ACTIVE;

    @Column(nullable = false, precision = 15, scale = 2)
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;


    @Enumerated(EnumType.STRING)
    private TypedeCompte typedeCompte ;

    @Enumerated(EnumType.STRING)
    private TypedeTransaction typedeTransaction;

    /**
     * @ManyToOne LAZY : plusieurs comptes → un seul user.
     * FetchType.LAZY = Hibernate ne charge PAS le User automatiquement.
     * Il le charge uniquement quand vous appellez account.getUser().
     * Sans LAZY → chaque SELECT compte charge aussi le user → N+1 queries.
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Utilisateur utilisateur;



    /**
     * @OneToMany LAZY + CascadeType.ALL :
     * - LAZY     → les transactions ne sont PAS chargées par défaut
     * - mappedBy → la clé étrangère (account_id) est dans la table transactions

     */
    @OneToMany(mappedBy = "compte",
            fetch = FetchType.LAZY)
    @Builder.Default
    private List<Transaction> transactions = new ArrayList<>();

    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }
}






