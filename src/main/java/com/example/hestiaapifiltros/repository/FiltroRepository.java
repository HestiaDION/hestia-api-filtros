package com.example.hestiaapifiltros.repository;

import com.example.hestiaapifiltros.model.Filtro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FiltroRepository extends JpaRepository<Filtro, UUID> {
    List<Filtro> findFiltroByCcategoriaIgnoreCase(String ccategoria);
    @Query("SELECT DISTINCT f.ccategoria FROM filtro f")
    List<String> findCategorias();
}
