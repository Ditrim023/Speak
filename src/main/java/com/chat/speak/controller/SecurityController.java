package com.chat.speak.controller;

import com.chat.speak.model.ChatUser;
import com.chat.speak.repository.RoomRepository;
import com.chat.speak.services.ChatUserService;
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
public class SecurityController {

    private final ChatUserService chatUserService;

    @RequestMapping(value = "/system/main", method = RequestMethod.GET)
    public String start() {
        return "system/main";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(final Model model) {
        final ChatUser currentUser = chatUserService.findUserByLogin();
        model.addAttribute("title", "Profile");
        model.addAttribute("currentUser", currentUser);
        return "system/profile";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/system/login";
    }

}
