package com.example.foyer.InterfaceImpl;

import com.example.foyer.entities.Bloc;

import java.util.List;

public interface BlocImpl {
    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    List<Bloc> getAllBlocs();
    Bloc getBlocById(Long idBloc);
    void deleteBloc(Long idBloc);
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;

}
