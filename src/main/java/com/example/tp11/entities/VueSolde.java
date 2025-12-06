package com.example.tp11.entities;

import org.springframework.data.rest.core.config.Projection;

// Projection pour exposer uniquement le solde d'un compte
@Projection(name = "infoSolde", types = Compte.class)
public interface VueSolde {
    double getMontant();
}
