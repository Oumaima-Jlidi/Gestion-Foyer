package com.example.foyer.services;

import com.example.foyer.Exception.ResourceNotFoundException;
import com.example.foyer.InterfaceImpl.BlocImpl;
import com.example.foyer.entities.Bloc;
import com.example.foyer.entities.Chambre;
import com.example.foyer.repos.BlocRepo;
import com.example.foyer.repos.ChambreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BlocService implements BlocImpl {
   @Autowired
   private BlocRepo blocRepo;
    @Autowired
    private ChambreRepo chambreRepo;
    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc getBlocById(Long idBloc) {
        return blocRepo.findById(idBloc).orElseThrow(()->new ResourceNotFoundException("Not found tutorial with id ="+idBloc));
    }

    @Override
    public void deleteBloc(Long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
       Bloc bloc=blocRepo.findById(idBloc).orElseThrow(()->new ResourceNotFoundException("Not found tutorial with id ="+idBloc));
       for(Long id:numChambre){
           Chambre chambre=chambreRepo.findById(id).orElse(null);
           chambre.setBloc(bloc);
           chambreRepo.save(chambre);
       }
        return blocRepo.save(bloc);
    }
    public ResponseEntity<Bloc> partialUpdateBlocs(Long idBloc, Map<String, Object> updates) {
        Optional<Bloc> bloc = Optional.ofNullable(blocRepo.findById(idBloc).orElseThrow(() -> new ResourceNotFoundException("il n'existe pas le cours avec l'id  = " + idBloc)));


        if (bloc.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Bloc blocs = bloc.get();

        updates.forEach((key, value) -> {
            if (value != null) {
                try {
                    Field field = Bloc.class.getDeclaredField(key);
                    field.setAccessible(true);

                    if (field.getType().isEnum()) {
                        // Vérifier si le champ est de type enum
                        Enum<?> enumValue = Enum.valueOf((Class<Enum>) field.getType(), (String) value);
                        field.set(blocs, enumValue);
                    } else {
                        field.set(blocs, value);
                    }
                } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
                    e.printStackTrace(); // Gérer l'exception selon vos besoins
                }
            }
        });

        blocRepo.save(blocs);

        return ResponseEntity.ok(blocs);
    }
}
