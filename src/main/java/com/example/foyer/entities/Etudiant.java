package com.example.foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEtudiant;
    String nomEt;
    String prenomEt;
    Long cin;
    String ecole ;
    Date DateNaissance;
    @ManyToMany(mappedBy = "etudiants")
    @JsonIgnore
    Set<Reservation> reservations;
}
