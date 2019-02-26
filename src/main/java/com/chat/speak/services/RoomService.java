package com.chat.speak.services;

import com.chat.speak.model.Comment;
import com.chat.speak.model.CommentJsonData;
import com.chat.speak.model.Room;
import com.chat.speak.repository.CommentRepository;
import com.chat.speak.repository.RoomRepository;
import com.chat.speak.util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Nikita Krutoguz
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoomService {
    private final RoomRepository roomRepository;
    private final CommentRepository commentRepository;
    private final ChatUserService chatUserService;

    public final Room findOne(final Long roomId) {
        return roomRepository.findOne(roomId);
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public final void saveComment(final Long roomId, final String text) {
        final Room room = roomRepository.findOne(roomId);
        String author = chatUserService.findUserByLogin(Util.getAuthorizedUserName()).getLogin();
        commentRepository.save(new Comment(text,room,author));
        addJson(roomId);
    }

    public final void saveCommentFromBot(final Long roomId, final String text) {
        final Room room = roomRepository.findOne(roomId);
        String author = "RudeBot";
        commentRepository.save(new Comment(text,room,author));
        addJson(roomId);
    }

    public void addJson(final Long id) {
        List<Comment> commentList = commentRepository.findAllUserByRoleId(id);
        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        CommentJsonData commentJsonData = new CommentJsonData();
        try (FileWriter file = new FileWriter("src/main/resources/templates/json/" + id + "json.json")) {
            file.write("[");
                for (int i = 0 ; i < commentList.size(); i++) {
                    commentJsonData.setAuthor(commentList.get(i).getAuthor());
                    commentJsonData.setText(commentList.get(i).getText());
                    String json = GSON.toJson(commentJsonData);
                    file.write(json);
                    file.write(",");
                }
            file.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
