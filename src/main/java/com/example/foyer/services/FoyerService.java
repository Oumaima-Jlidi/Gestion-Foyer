package com.example.foyer.services;

import com.example.foyer.InterfaceImpl.FoyerImpl;
import com.example.foyer.entities.Bloc;
import com.example.foyer.entities.Foyer;
import com.example.foyer.entities.Universite;
import com.example.foyer.repos.BlocRepo;
import com.example.foyer.repos.FoyerRepo;
import com.example.foyer.repos.UniversiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FoyerService implements FoyerImpl {
    @Autowired
    private FoyerRepo foyerRepo;
    @Autowired
    private UniversiteRepo universiteRepo;
    @Autowired
    private BlocRepo blocRepo;
    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer getFoyerById(Long idFoyer) {
        return foyerRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public void deleteFoyer(Long idFoyer) {
        foyerRepo.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite= universiteRepo.findById(idUniversite).orElse(null);
        universite.setFoyer(foyer);
        for (Bloc bloc:foyer.getBlocs()){
            bloc.setFoyer(foyer);
            blocRepo.save(bloc);
        }
        return foyer;
    }
}
