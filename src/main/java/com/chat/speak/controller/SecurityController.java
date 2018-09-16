package com.chat.speak.controller;

import com.chat.speak.repository.RoomRepository;
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


    @RequestMapping(value = "/main/start", method = RequestMethod.GET)
    public String start() {
        return "main/start";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


}
