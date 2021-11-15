package ua.cv.vacancy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import ua.cv.vacancy.model.Message;
import ua.cv.vacancy.repository.MesageRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MesageRepository repository;
    private final MailService mailSender;

    @Autowired
    public MessageService(MesageRepository repository, MailService sender) {
        this.repository = repository;
        this.mailSender = sender;
    }

    public List<Message> findAllMessage() {
        return repository.findAll();
    }

    public Message findById(Long id) {
        return repository.getById(id);
    }

    public void saveMessege(Message message) {
        if (!StringUtils.isEmpty(message.getEmail()) && !StringUtils.isEmpty(message.getMessage())) {
            message.setCreated_on(LocalDateTime.now());
            repository.save(message);
            System.out.println("Save_messageService :: " + message.getEmail() + ", " +
                    "phone: " + message.getPhoneNumber() + ", " + message.getMessage() + ", success !!! ");
            mailSender.sendingEmail(message);
        }
    }

    public void deleteMessageById(Long id) {
        repository.deleteById(id);
    }
}