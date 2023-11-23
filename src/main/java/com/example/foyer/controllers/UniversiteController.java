package com.example.foyer.controllers;

import com.example.foyer.entities.Universite;
import com.example.foyer.services.UniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("universites")
@RequiredArgsConstructor

public class UniversiteController {
    private  final UniversiteService universiteService;
    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @GetMapping("/all")
    public List<Universite> getAllUniversites() {
        return universiteService.getAlluniversites();
    }

    @GetMapping("/{idUniversite}")
    public Universite getUniversiteById(@PathVariable Long idUniversite) {
        return universiteService.getUniversiteById(idUniversite);
    }

    @DeleteMapping("/delete/{idUniversite}")
    public void deleteUniversite(@PathVariable Long idUniversite) {
        universiteService.deleteUniversite(idUniversite);

    }
    @PutMapping("affecter/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable Long idFoyer,@PathVariable String nomUniversite){
        return universiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);

    }
}
