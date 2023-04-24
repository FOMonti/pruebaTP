package com.labo.prueba.dto.email;

import lombok.Data;

@Data
public class EmailDTO {

    private String receiverEmail;

    private String subject;

    private String body;
}
