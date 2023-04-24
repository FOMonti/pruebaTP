package com.labo.prueba.mapper;

import com.labo.prueba.dto.articulo.ArticuloDTO;
import com.labo.prueba.entity.Articulo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticuloMapper {

    public List<ArticuloDTO> getArtDtos(List<Articulo> articulos){
        ArticuloDTO articuloDTO;
        List<ArticuloDTO> ret = new ArrayList<>();
        for (Articulo articulo : articulos){
            articuloDTO = artToDTO(articulo);
            ret.add(articuloDTO);
        }
        return ret;
    }

    private ArticuloDTO artToDTO(Articulo articulo) {
        ArticuloDTO articuloDTO = new ArticuloDTO();
        articuloDTO.setId(articulo.getId());
        articuloDTO.setNombre(articulo.getNombre());
        articuloDTO.setPrecio(articulo.getPrecio());
        return articuloDTO;
    }

    public Articulo dtoToArt(ArticuloDTO articuloDTO){
        Articulo articulo = new Articulo();
        articulo.setId(articuloDTO.getId());
        articulo.setNombre(articuloDTO.getNombre());
        articulo.setPrecio(articuloDTO.getPrecio());
        return articulo;

    }
}
