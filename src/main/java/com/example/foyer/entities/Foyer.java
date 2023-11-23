package com.example.foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFoyer;

     String nomFoyer;
     Long capaciteFoyer ;
@OneToOne(mappedBy = "foyer")
    @JsonIgnore
    Universite universite;

@OneToMany(mappedBy = "foyer",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch =FetchType.EAGER)
    Set<Bloc> blocs;

}
