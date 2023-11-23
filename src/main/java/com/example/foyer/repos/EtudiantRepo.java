package com.example.foyer.repos;

import com.example.foyer.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
    Etudiant findByCin(Long cin);
}
