package com.chat.speak.controller;

import com.chat.speak.repository.PhraseRepository;
import com.chat.speak.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.exceptions.TemplateInputException;

/**
 * @author Nikita Krutoguz
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AjaxController {
    private final RoomService roomService;
    private final PhraseRepository phraseRepository;

    @ResponseBody
    @RequestMapping(value = "/answer-from-bot/{id}", method = RequestMethod.GET)
    public final void addPhrase(@PathVariable("id") final Long id) throws TemplateInputException{
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long i = 1L + (long) (Math.random() * (8L - 1L));
        final String phraseFromBot = phraseRepository.findOne(i).getText();
            roomService.saveCommentFromBot(id, phraseFromBot); }


}



