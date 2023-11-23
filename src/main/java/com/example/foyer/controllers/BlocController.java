package com.example.foyer.controllers;

import com.example.foyer.entities.Bloc;
import com.example.foyer.services.BlocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("blocs")
@RequiredArgsConstructor

public class BlocController {
    private final BlocService blocService;

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping("/update")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @GetMapping("/all")
    public List<Bloc> getAllBlocs() {
        return blocService.getAllBlocs();
    }

    @GetMapping("/{idBloc}")
    public Bloc getBlocById(@PathVariable Long idBloc) {
        return blocService.getBlocById(idBloc);
    }

    @DeleteMapping("/delete/{idBloc}")
    public void deleteBloc(@PathVariable Long idBloc) {
        blocService.deleteBloc(idBloc);

    }
    @PutMapping("/affecterChambre/{idBloc}")
    public Bloc affecterChambreAbloc (@RequestBody List<Long>numChambre,@PathVariable Long idBloc){
        return blocService.affecterChambresABloc(numChambre,idBloc);
    }
    @PatchMapping("/update/{idBloc}")
    public ResponseEntity<Bloc>partialUpdateBlocs(@PathVariable Long idBloc, @RequestBody Map<String, Object> updates){
        return blocService.partialUpdateBlocs(idBloc,updates);
    }
}
