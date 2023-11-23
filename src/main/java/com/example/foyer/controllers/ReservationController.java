package com.example.foyer.controllers;

import com.example.foyer.entities.Reservation;
import com.example.foyer.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservations")
@RequiredArgsConstructor

public class ReservationController {
    private final ReservationService reservationService;
    @PostMapping("/add")
    public Reservation addBloc(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/update")
    public Reservation updateBloc(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("/all")
    public List<Reservation> getAllBlocs() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{idReservation}")
    public Reservation getReservationById(@PathVariable Long idReservation) {
        return reservationService.getReservationById(idReservation);
    }

    @DeleteMapping("/delete/{idReservation}")
    public void deleteReservation(@PathVariable Long idReservation) {
        reservationService.deleteReservation(idReservation);

    }
    @PostMapping("/add/{idChambre}/{cin}")
    public Reservation ajouterReservation(@PathVariable Long idChambre, @PathVariable Long cin) {
        return reservationService.ajouterReservation(idChambre, cin);
    }

    @PutMapping("/annulerReservation/{cin}")
    public Reservation annulerReservation(@PathVariable Long cin) {
        return reservationService.annulerReservation(cin);
    }
}
