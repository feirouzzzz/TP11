package com.example.tp11.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;

    private double montant;

    @Temporal(TemporalType.DATE)
    private Date dateOuverture;

    @Enumerated(EnumType.STRING)
    private NatureCompte categorieCompte;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
}
