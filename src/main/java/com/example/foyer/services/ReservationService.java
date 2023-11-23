package com.example.foyer.services;

import com.example.foyer.InterfaceImpl.ReservationImpl;
import com.example.foyer.entities.Chambre;
import com.example.foyer.entities.Etudiant;
import com.example.foyer.entities.Reservation;
import com.example.foyer.enums.TypeChambre;
import com.example.foyer.repos.ChambreRepo;
import com.example.foyer.repos.EtudiantRepo;
import com.example.foyer.repos.ReservationRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor

public class ReservationService implements ReservationImpl {
    private final ReservationRepo reservationRepo;
    private final EtudiantRepo etudiantRepo;
    private final ChambreRepo chambreRepo;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation getReservationById(Long idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public void deleteReservation(Long idReservation) {
        reservationRepo.deleteById(idReservation);
    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cin) {
        Chambre chambre = chambreRepo.findById(idChambre).orElse(null);

        Etudiant etudiant = etudiantRepo.findByCin(cin);

        // Création de la réservation
        Reservation reservation = new Reservation();
        assert chambre != null;
        reservation.setIdReservation(Long.valueOf(chambre.getNumeroChambre() + "-" + chambre.getBloc().getNomBloc().replace(" ", "") + "-" + cin));
        reservation.setAnneeUniversitaire(LocalDate.of(LocalDate.now().getYear(), 9, 1));
        reservation.setEstValide(true);

        // Déterminer la capacité maximale en fonction du type de chambre
        int capaciteMax = 0;
        if (TypeChambre.SIMPLE.equals(chambre.getTypeC())) {
            capaciteMax = 1;
        } else if (TypeChambre.DOUBLE.equals(chambre.getTypeC())) {
            capaciteMax = 2;
        } else if (TypeChambre.TRIPLE.equals(chambre.getTypeC())) {
            capaciteMax = 3;
        }

        // Vérifier si la capacité maximale de la chambre est atteinte
        long nombreReservations = chambre.getReservations().size();
        if (nombreReservations >= capaciteMax) {
            throw new IllegalStateException("La capacité maximale de la chambre est atteinte.");
        }

        // Gérer la relation ManyToMany
        Set<Etudiant> etudiants = new HashSet<>();
        etudiants.add(etudiant);
        reservation.setEtudiants(etudiants);

        // Sauvegarder la réservation
        Reservation savedReservation = reservationRepo.save(reservation);

        // Ajouter la réservation à la collection de réservations de la chambre et sauvegarder
        chambre.getReservations().add(savedReservation);
        chambreRepo.save(chambre);

        return savedReservation;
    }

    @Override
    @Transactional
    public Reservation annulerReservation(long cin) {
        // Trouver l'étudiant et sa réservation

        Etudiant etudiant=etudiantRepo.findByCin(cin);
        // Supposition: chaque étudiant a au maximum une réservation valide
        Reservation reservation=etudiant.getReservations().stream()
        .filter(Reservation::getEstValide)
        .findFirst()
                .orElse(null);
        // Mettre à jour l'état de la réservation
        reservation.setEstValide(false);
        // Désaffecter l'étudiant
        reservation.getEtudiants().remove(etudiant);
        // Désaffecter la chambre associée et mettre à jour sa capacité
        Chambre chambreAssocie = chambreRepo.findByReservationsContains(reservation);
if(chambreAssocie!= null){
    chambreAssocie.getReservations().remove(reservation);
    chambreRepo.save(chambreAssocie); // Sauvegarder les changements dans la chambre

}
        // Sauvegarder les modifications

        return reservationRepo.save(reservation);
    }


}
