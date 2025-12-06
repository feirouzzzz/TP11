package com.example.tp11.entities;

import org.springframework.data.rest.core.config.Projection;

// Projection affichée dans un contexte mobile : solde + type de compte
@Projection(name = "vueMobile", types = Compte.class)
public interface CompteViewMobile {
    double getMontant(); // ou montant

    NatureCompte getCategorieCompte();
}
