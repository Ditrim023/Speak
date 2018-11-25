package com.chat.speak.controller;

import com.chat.speak.model.Comment;
import com.chat.speak.model.Room;
import com.chat.speak.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nikita Krutoguz
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {

    private final RoomService roomService;

    @RequestMapping(value = "/room/list", method = RequestMethod.GET)
    public String listRooms(final Model model) {
        model.addAttribute("title", "All Rooms");
        model.addAttribute("rooms", roomService.findAll());
        return "room/list";
    }

    @RequestMapping(path = "/room/chat/{id}", method = RequestMethod.GET)
    public String infoRoom(final Model model, @PathVariable("id") final Long id) {
        final Room room = roomService.findOne(id);
        model.addAttribute("room", room);
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", room.getComments());
        model.addAttribute("title", room.getName());
        return "room/chat";
    }

    @RequestMapping(value = "/comment/save/", method = RequestMethod.POST)
    public final String saveComment(final @RequestParam Long id, final @RequestParam String text) {
        roomService.saveComment(id, text);
        return "redirect:/room/chat/" + id;
    }



}
