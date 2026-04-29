package com.example.demo.Entitys;
import com.example.demo.Enum.TypedeTransaction;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * PRINCIPE D'IMMUABILITÉ BANCAIRE :
 *
 * Une transaction NE DOIT JAMAIS être modifiée après création.
 * C'est une trace comptable. Si une erreur existe, on crée une
 * transaction corrective — jamais on ne modifie l'existante.
 *
 * C'est pourquoi :
 *  - pas de @PreUpdate
 *  - createdAt a @Column(updatable = false)
 *  - les champs balanceBefore/balanceAfter permettent de reconstituer
 *    l'historique complet sans jamais regarder le solde actuel
 *
 * @Index sur account_id et createdAt → les requêtes de relevé
 * ("transactions du compte X entre le 01/01 et le 31/01") sont
 * ultra-rapides grâce à ces index MySQL.
 */
@Entity
@Table(name = "transactions",  indexes = {
        @Index(name = "idx_id",  columnList = "id"),
        @Index(name = "idx_created_at",  columnList = "createdAt"),
        @Index(name = "idx_reference",   columnList = "referenceNumero") // Vérifiez que le nom correspond au champ
})

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String referenceNumero; // TXN-20241201120000-000123

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypedeTransaction typedeTransaction;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal montant;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal balanceBefore; // solde AVANT l'opération

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal balanceAfter;  // solde APRÈS l'opération

    private String description;

    // Seulement pour les virements : numéro du compte destinataire
    private String targetNumerodeCompte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Compte  compte;

    @Column(updatable = false) // JAMAIS modifié — trace comptable
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); }
}