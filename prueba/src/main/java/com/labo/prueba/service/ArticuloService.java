package com.labo.prueba.service;

import com.labo.prueba.dto.articulo.ArticuloDTO;
import com.labo.prueba.exception.BadRequestException;
import com.labo.prueba.entity.Articulo;
import com.labo.prueba.handler.MessageHandler;
import com.labo.prueba.mapper.ArticuloMapper;
import com.labo.prueba.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService {

    private final ArticuloRepository articuloRepository;
    private final MessageHandler messageHandler;
    private final ArticuloMapper articuloMapper;


    @Autowired
    public ArticuloService(ArticuloRepository articuloRepository, MessageHandler messageHandler,
                           ArticuloMapper articuloMapper){
        this.articuloRepository = articuloRepository;
        this.messageHandler = messageHandler;
        this.articuloMapper = articuloMapper;
    }

    public void save(ArticuloDTO articuloDTO){
        Optional<Articulo> articuloOptional = articuloRepository.findOptionalById(articuloDTO.getId());
        if (articuloOptional.isPresent())
            throw new BadRequestException(messageHandler.articuloFound);
        articuloRepository.save(articuloMapper.dtoToArt(articuloDTO));
    }

    public List<ArticuloDTO> getAll() {
        List<Articulo> articulos = articuloRepository.findAll();
        return articuloMapper.getArtDtos(articulos);
    }
}
