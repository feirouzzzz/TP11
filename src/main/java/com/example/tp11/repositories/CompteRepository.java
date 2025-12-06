package com.example.tp11.repositories;

import com.example.tp11.entities.Compte;
import com.example.tp11.entities.NatureCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "comptes", collectionResourceRel = "listeComptes", itemResourceRel = "compteDetail")
public interface CompteRepository extends JpaRepository<Compte, Long> {

    @RestResource(path = "recherche-par-type")
    List<Compte> findByCategorieCompte(@Param("categorie") NatureCompte categorie);
}
