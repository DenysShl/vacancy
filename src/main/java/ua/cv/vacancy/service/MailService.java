package ua.cv.vacancy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ua.cv.vacancy.model.Message;

@Service
public class MailService extends SimpleMailMessage {

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String userFrom;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendingEmail(Message message) {
        SimpleMailMessage msg = new SimpleMailMessage();
        // Необходимо указать адрес электронной почты отправителя
        msg.setFrom(userFrom);

        // Необходимо указать адрес электронной почты получателя
        msg.setTo(message.getEmail());

        // Установить тему: поле заголовка
        msg.setSubject("Запит з порталу стосовно вакансії");

        // Установить актуальное сообщение
        msg.setText("Від: " + message.getEmail() + "\n message: " + message.getMessage());

        try {
            javaMailSender.send(msg);
            System.out.println("Message sending!");
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}