package com.example.foyer.services;

import com.example.foyer.InterfaceImpl.UniversiteImpl;
import com.example.foyer.entities.Foyer;
import com.example.foyer.entities.Universite;
import com.example.foyer.repos.FoyerRepo;
import com.example.foyer.repos.UniversiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UniversiteService implements UniversiteImpl {
    @Autowired
    private UniversiteRepo universiteRepo;
    @Autowired
    private FoyerRepo foyerRepo;
    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepo.save(universite)   ;
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepo.save(universite) ;
    }

    @Override
    public List<Universite> getAlluniversites() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite getUniversiteById(Long idUniversite) {
        return universiteRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public void deleteUniversite(Long idUniversite) {
        universiteRepo.deleteById(idUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer =foyerRepo.findById(idFoyer).orElse(null);
         Universite universite=universiteRepo.findByNomUniversite(nomUniversite);
         universite.setFoyer(foyer);
        return universiteRepo.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite=universiteRepo.findById(idUniversite).orElse(null);
        universite.setFoyer(null);
        return universiteRepo.save(universite);
    }
}
