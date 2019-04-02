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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    public final void addPhrase(@PathVariable("id") final Long id) throws TemplateInputException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (id==1){
            long i = 1L + (long) (Math.random() * (8L - 1L));
            final String phraseFromBot = phraseRepository.findOne(i).getText();
            roomService.saveCommentFromBot(id, phraseFromBot);
        }
    }


    @ResponseBody
    @RequestMapping(value = "/json/{id}", method = RequestMethod.GET)
    public final String getJson(@PathVariable("id") final Long id){
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/templates/json/"+id+"room.json"));
            char[] buf = new char[1024];
            int numRead = 0;
            while ((numRead = reader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
            }
            reader.close();
        } catch (IOException e) {
        }
        return fileData.toString();

    }
}



