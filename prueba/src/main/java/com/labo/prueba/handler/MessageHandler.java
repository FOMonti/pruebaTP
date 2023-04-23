package com.labo.prueba.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:messages.properties")
public class MessageHandler {


    public final String articuloFound;

    @Autowired
    public MessageHandler(@Value("${articulo.found}") String articuloFound){
        this.articuloFound = articuloFound;
    }
}
