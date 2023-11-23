package com.example.foyer.InterfaceImpl;

import com.example.foyer.entities.Reservation;

import java.util.List;

public interface ReservationImpl {
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getReservationById(Long idReservation);
    void deleteReservation(Long idReservation);
     Reservation ajouterReservation(long idChambre, long cin) ;
     Reservation annulerReservation(long cin) ;
}
