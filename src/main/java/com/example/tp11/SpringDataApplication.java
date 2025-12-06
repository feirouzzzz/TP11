package com.example.tp11;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.tp11.entities.Client;
import com.example.tp11.entities.Compte;
import com.example.tp11.entities.NatureCompte;
import com.example.tp11.repositories.ClientRepository;
import com.example.tp11.repositories.CompteRepository;

import java.util.Date;

@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Bean
    CommandLineRunner initialisation(
            CompteRepository compteRepo,
            ClientRepository clientRepo,
            RepositoryRestConfiguration restConfig) {
        return args -> {

            // Exposer les IDs pour les comptes
            restConfig.exposeIdsFor(Compte.class);

            // Création de clients
            Client clientA = clientRepo.save(new Client("Amal", "amal@email.com"));
            Client clientB = clientRepo.save(new Client("Ali", "ali@email.com"));

            // Création de comptes
            compteRepo.save(new Compte(null, Math.random() * 9000, new Date(), NatureCompte.EPARGNE, clientA));
            compteRepo.save(new Compte(null, Math.random() * 9000, new Date(), NatureCompte.COURANT, clientA));
            compteRepo.save(new Compte(null, Math.random() * 9000, new Date(), NatureCompte.EPARGNE, clientB));

            // Affichage
            compteRepo.findAll().forEach(System.out::println);
        };
    }
}
