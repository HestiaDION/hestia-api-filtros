package com.example.hestiaapifiltros.controller;

import com.example.hestiaapifiltros.model.Filtro;
import com.example.hestiaapifiltros.service.FiltroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@ControllerAdvice
@RestController
@RequestMapping("/filtros")
public class FiltroController {

    private final FiltroService filtroService;
    public FiltroController(FiltroService filtroService) {
        this.filtroService = filtroService;
    }

    @GetMapping("/todos")
    @Operation(summary = "Lista todos os filtros cadastrados",
            description = "Retorna uma lista com todos os filtros cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações dos filtros retornados com sucesso!",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Filtro.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content())
    })
    public List<Filtro> getAllFiltros() {
        return filtroService.getAllFiltros();
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Lista todos os filtros cadastrados de uma categoria",
            description = "Retorna uma lista com todos os filtros cadastrados de uma categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Informações dos filtros retornados com sucesso!",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Filtro.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content())
    })
    public List<Filtro> getAllFiltrosByCategoria(@Parameter(name = "categoria", description = "É necessário uma categoria", required = true) @PathVariable String categoria) {
        return filtroService.getByCategoria(categoria);
    }

    @GetMapping("/")
    @Operation(summary = "Lista todos as diferentes categorias",
            description = "Retorna uma lista com todas as categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categorias retornadas com sucesso!",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Filtro.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content())
    })
    public List<String> getCategorias() {
        return filtroService.findCategorias();
    }

    @GetMapping("/getCategoria/{cnome}")
    @Operation(summary = "Retorna a categoria de acordo com o nome",
            description = "Retorna a categoria de acordo com o nome")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categorias retornadas com sucesso!",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Filtro.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content())
    })
    public String getCategoriaByNome(@Parameter(name = "cnome", description = "É necessário o nome do filtro", required = true) @PathVariable String cnome) {
        return filtroService.getCategoriaByNome(cnome);
    }
}
