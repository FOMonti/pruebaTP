package com.labo.prueba.email;

public interface IEmailService {

    void sendText(String receiver, String subject, String content) throws Exception;

}
