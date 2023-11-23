package com.example.foyer.services;

import com.example.foyer.InterfaceImpl.EtudiantImpl;
import com.example.foyer.entities.Etudiant;
import com.example.foyer.repos.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EtudiantService implements EtudiantImpl {
   @Autowired
   private EtudiantRepo etudiantRepo;
    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepo.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).orElse(null);
    }

    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);
    }
}
