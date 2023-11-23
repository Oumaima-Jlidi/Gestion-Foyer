package com.example.foyer.controllers;

import com.example.foyer.entities.Foyer;
import com.example.foyer.services.FoyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("foyers")
@RequiredArgsConstructor

public class FoyerController {
    private final FoyerService foyerService;
    @PostMapping("/add")
    public Foyer addidFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PutMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @GetMapping("/all")
    public List<Foyer> getAllBlocs() {
        return foyerService.getAllFoyers();
    }

    @GetMapping("/{idFoyer}")
    public Foyer getFoyerById(@PathVariable Long idFoyer) {
        return foyerService.getFoyerById(idFoyer);
    }

    @DeleteMapping("/delete/{idFoyer}")
    public void deleteFoyer(@PathVariable Long idFoyer) {
        foyerService.deleteFoyer(idFoyer);

    }
}
