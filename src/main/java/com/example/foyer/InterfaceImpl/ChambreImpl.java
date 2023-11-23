package com.example.foyer.InterfaceImpl;

import com.example.foyer.entities.Chambre;
import com.example.foyer.enums.TypeChambre;

import java.util.List;

public interface ChambreImpl {
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    List<Chambre> getAllChambres();
    Chambre getChambreById(Long idChambre);
    void deleteChambre(Long idChambre);
     List<Chambre> getChambresParNomUniversite( String nomUniversite) ;
     List<Chambre> getChambresParBlocEtType (long idBloc, TypeChambre
            typeC) ;
}
