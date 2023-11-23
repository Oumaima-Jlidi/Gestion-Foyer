package com.example.foyer.repos;

import com.example.foyer.entities.Chambre;
import com.example.foyer.entities.Reservation;
import com.example.foyer.enums.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChambreRepo extends JpaRepository<Chambre,Long> {
    Chambre findByReservationsContains(Reservation reservation);
    List<Chambre> getChambresParNomUniversite(String nomUniversite);
    //Solution 1
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC);

    //Solution 2
    List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, TypeChambre typeC);

}
