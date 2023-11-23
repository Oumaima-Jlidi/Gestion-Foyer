package com.example.foyer.InterfaceImpl;

import com.example.foyer.entities.Universite;

import java.util.List;

public interface UniversiteImpl {
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    List<Universite> getAlluniversites();
    Universite getUniversiteById(Long idUniversite);
    void deleteUniversite(Long idUniversite);
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;
}
