package com.example.foyer.services;

import com.example.foyer.InterfaceImpl.ChambreImpl;
import com.example.foyer.entities.Chambre;
import com.example.foyer.enums.TypeChambre;
import com.example.foyer.repos.ChambreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ChambreService implements ChambreImpl {
    @Autowired
    private ChambreRepo chambreRepo;
    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepo.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepo.save(chambre);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre getChambreById(Long idChambre) {
        return chambreRepo.findById(idChambre).orElse(null);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepo.getChambresParNomUniversite(nomUniversite);  //Solution 1
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepo.getChambresParBlocEtType(idBloc,typeC);
    }
}
