package com.example.foyer.entities;

import com.example.foyer.enums.TypeChambre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChambre;
    Long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;
    @ManyToOne
    @JoinColumn(name = "idBloc")

    Bloc bloc;
    @OneToMany
    Set<Reservation> reservations;
}
