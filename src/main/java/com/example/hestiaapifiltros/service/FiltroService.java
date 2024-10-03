package com.example.hestiaapifiltros.service;

import com.example.hestiaapifiltros.model.Filtro;
import com.example.hestiaapifiltros.repository.FiltroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltroService {
    private final FiltroRepository filtroRepository;
    public FiltroService(FiltroRepository filtroRepository) {
        this.filtroRepository = filtroRepository;
    }

    // get all
    public List<Filtro> getAllFiltros() {
        return filtroRepository.findAll();
    }

    // get by categoria
    public List<Filtro> getByCategoria(String ccategoria){
        return filtroRepository.findFiltroByCcategoriaIgnoreCase(ccategoria);
    }
}
