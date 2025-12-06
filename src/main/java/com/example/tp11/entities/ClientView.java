package com.example.tp11.entities;

import org.springframework.data.rest.core.config.Projection;

// Projection personnalisée pour exposer certaines infos d'un client
@Projection(name = "detailsClient", types = Client.class)
public interface ClientView {

    // Retourne le nom du client
    String getNom();

    // Retourne l'adresse email du client
    String getEmail();
}
