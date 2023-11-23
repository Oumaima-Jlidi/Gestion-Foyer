package com.example.foyer.repos;

import com.example.foyer.entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversiteRepo extends JpaRepository<Universite,Long> {
    Universite findByNomUniversite(String nomUniversite);
}
