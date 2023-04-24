package com.labo.prueba.controllers;

import com.labo.prueba.constants.ArticuloEndPoint;
import com.labo.prueba.dto.email.EmailDTO;
import com.labo.prueba.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("email")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
public class EmailController {

    private final EmailServiceImpl emailService;

    @Autowired
    public EmailController(EmailServiceImpl emailService){
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> enviarEmail(@RequestBody EmailDTO emailDTO){
        try {
            emailService.sendText(emailDTO.getReceiverEmail(),emailDTO.getSubject(),emailDTO.getBody());
        }catch (Exception e){
            return new ResponseEntity<>("Error al enviar el email", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Email Enviado", HttpStatus.OK);
    }
}
