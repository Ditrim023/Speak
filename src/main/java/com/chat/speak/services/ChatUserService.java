package com.chat.speak.services;

import com.chat.speak.model.ChatUser;
import com.chat.speak.repository.ChatUserRepository;
import com.chat.speak.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nikita Krutoguz
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChatUserService {
    private final ChatUserRepository chatUserRepository;


    public final ChatUser findUserByLogin() {
        return chatUserRepository.findChatUserByLogin(Util.getAuthorizedUserName());
    }
}
