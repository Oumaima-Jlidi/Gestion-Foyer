package com.example.foyer.repos;

import com.example.foyer.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoyerRepo extends JpaRepository<Foyer,Long> {
}
