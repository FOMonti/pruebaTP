package com.labo.prueba.controllers;

import com.labo.prueba.constants.ArticuloEndPoint;
import com.labo.prueba.dto.articulo.ArticuloDTO;
import com.labo.prueba.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ArticuloEndPoint.ARTICULO_CONTROLLER)
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class ArticuloController {

    private final ArticuloService articuloService;

    @Autowired
    public ArticuloController(ArticuloService articuloService){
        this.articuloService = articuloService;
    }

    @PostMapping(ArticuloEndPoint.ART_SAVE)
    public ResponseEntity<String> crearArticulo(@RequestBody ArticuloDTO articuloDTO) {
        articuloService.save(articuloDTO);
        return new ResponseEntity<>("Articulo Creado", HttpStatus.CREATED);
    }

    @GetMapping(ArticuloEndPoint.ART_GET)
    public ResponseEntity<List<ArticuloDTO>> getArticulos() {
        return ResponseEntity.ok(articuloService.getAll());
    }


}
