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
public class RoomController {

    private final RoomRepository roomRepository;

    @RequestMapping(value = "/room/list", method = RequestMethod.GET)
    public String listPatients(final Model model) {
        model.addAttribute("title", "All Rooms");
        model.addAttribute("rooms", roomRepository.findAll());
        return "main/start";
    }

}
