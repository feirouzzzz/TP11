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
public class CompteEnregistrement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifiant;

    private double montantActuel;

    @Temporal(TemporalType.DATE)
    private Date creation;

    @Enumerated(EnumType.STRING)
    private NatureCompte categorie;

    @ManyToOne
    @JoinColumn(name = "ref_client")
    private Client clientAssocie;
}
