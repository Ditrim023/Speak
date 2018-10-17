package com.chat.speak.services;

import com.chat.speak.model.Comment;
import com.chat.speak.model.Room;
import com.chat.speak.repository.CommentRepository;
import com.chat.speak.repository.RoomRepository;
import com.chat.speak.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (roomId==1L){
            saveCommentFromBot();
        }

    }

    public final void saveCommentFromBot(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final Room room = roomRepository.findOne(1L);
        commentRepository.save(new Comment("hello from Bot",room,"Bot"));
    }
}
