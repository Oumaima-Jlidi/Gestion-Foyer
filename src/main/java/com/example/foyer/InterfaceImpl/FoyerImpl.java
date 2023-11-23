package com.example.foyer.InterfaceImpl;

import com.example.foyer.entities.Foyer;

import java.util.List;

public interface FoyerImpl {
    Foyer addFoyer(Foyer foyer);
    Foyer updateFoyer(Foyer foyer);
    List<Foyer> getAllFoyers();
    Foyer getFoyerById(Long idFoyer);
    void deleteFoyer(Long idFoyer);
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;

}
