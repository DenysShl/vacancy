package ua.cv.vacancy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.cv.vacancy.model.Message;
import ua.cv.vacancy.service.MessageService;

import java.util.List;

@Controller
public class MessageController {

    private final MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping("/message")
    public String showMessage(Model model) {
        List<Message> messageList = service.findAllMessage();
        model.addAttribute("messageList", messageList);
        return "showMessage";
    }

    @GetMapping("/messageForm")
    public String saveMessageForm() {
        return "message_Form";
    }

    @PostMapping("/send")
    public String saveMessage(@ModelAttribute("messageSend") Message message) {
        service.saveMessege(message);
        return "redirect:/index";
    }
}