package com.example.foyer.InterfaceImpl;

import com.example.foyer.entities.Etudiant;

import java.util.List;

public interface EtudiantImpl {
    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Long idEtudiant);
    void deleteEtudiant(Long idEtudiant);

}
