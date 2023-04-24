package com.labo.prueba.email;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



@Service
public class EmailServiceImpl implements IEmailService{

    @Value("${app.sendgrid.sender}")
    private String sender;
    @Value("${app.sendgrid.apiKey}")
    private String apiKey;

    @Override
    public void sendText(String receiverEmail, String subject, String body) throws Exception {

        Email from = new Email(sender);
        Email to = new Email(receiverEmail);
        Content content = new Content("text/plain", body);

        Personalization personalization = new Personalization();
        personalization.addTo(to);
        personalization.addDynamicTemplateData("name", "Fernando");

        Mail mail = new Mail(from, subject, to, content);

        send(mail);

    }

    public void send(Mail mail) throws Exception {

        SendGrid sendGrid = new SendGrid(apiKey);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sendGrid.api(request);

        if (response.getStatusCode() != HttpStatus.ACCEPTED.value()) {
            throw new Exception("ERROR EMAIL");
        }
    }

}
