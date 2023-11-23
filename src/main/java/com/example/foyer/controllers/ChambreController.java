package com.example.foyer.controllers;

import com.example.foyer.entities.Chambre;
import com.example.foyer.enums.TypeChambre;
import com.example.foyer.services.ChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chambres")
@RequiredArgsConstructor

public class ChambreController {
    private final ChambreService chambreService;
    @PostMapping("/add")
    private Chambre addChambre(@RequestBody Chambre chambre){
        return chambreService.addChambre(chambre);
    }

    @PutMapping("/update")
    private Chambre updateChambre(@RequestBody Chambre chambre){
        return chambreService.updateChambre(chambre);
    }
    @GetMapping("/all")
    private List<Chambre> getChambres(){
        return chambreService.getAllChambres();
    }

    @GetMapping("/{idChambre}")
    public Chambre getChambreById(@PathVariable Long idChambre) {
        return chambreService.getChambreById(idChambre);
    }

    @DeleteMapping("/delete/{idChambre}")
    public void deleteChambre(@PathVariable Long idChambre) {
        chambreService.deleteChambre(idChambre);

    }
    @GetMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable Long idBloc, @PathVariable TypeChambre typeC) {
        return chambreService.getChambresParBlocEtType(idBloc, typeC);
    }
}
