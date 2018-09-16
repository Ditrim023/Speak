package com.chat.speak.controller;

import com.chat.speak.repository.ChatUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Nikita Krutoguz
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChatUserController {

    private final ChatUserRepository chatUserRepository;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String listPatients(final Model model) {
        model.addAttribute("title", "All Users");
        model.addAttribute("users", chatUserRepository.findAll());
        return "main/start";
    }
}
