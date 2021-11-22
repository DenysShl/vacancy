package ua.cv.vacancy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.cv.vacancy.model.Message;
import ua.cv.vacancy.service.MessageService;

import javax.validation.Valid;
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
    public String saveMessage(@ModelAttribute("messageSend") @Valid Message message,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println("Error !!!");
            System.out.println(bindingResult.getModel());
            System.out.println(bindingResult.getTarget());
            return "message_Form";
        }
        service.saveMessege(message);
        return "success_sending";
    }
}