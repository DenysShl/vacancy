package ua.cv.vacancy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.cv.vacancy.model.Message;
import ua.cv.vacancy.repository.MesageRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MesageRepository repository;

    @Autowired
    public MessageService(MesageRepository repository) {
        this.repository = repository;
    }

    public List<Message> findAllMessage() {
        return repository.findAll();
    }

    public Message findById(Long id) {
        return repository.getById(id);
    }

    public void saveMessege(Message message) {
        message.setCreated_on(LocalDateTime.now());
        repository.save(message);
    }

    public void deleteMessageById(Long id) {
        repository.deleteById(id);
    }
}