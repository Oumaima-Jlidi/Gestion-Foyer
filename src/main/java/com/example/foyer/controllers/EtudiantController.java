package com.example.foyer.controllers;

import com.example.foyer.entities.Etudiant;
import com.example.foyer.services.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("etudiants")
@RequiredArgsConstructor

public class EtudiantController {
    private final EtudiantService etudiantService;

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant bloc) {
        return etudiantService.updateEtudiant(bloc);
    }

    @GetMapping("/all")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{idEtudiant}")
    public Etudiant getEtudiantById(@PathVariable Long idEtudiant) {
        return etudiantService.getEtudiantById(idEtudiant);
    }

    @DeleteMapping("/delete/{idEtudiant}")
    public void deleteEtudiant(@PathVariable Long idEtudiant) {
        etudiantService.deleteEtudiant(idEtudiant);

    }
}
