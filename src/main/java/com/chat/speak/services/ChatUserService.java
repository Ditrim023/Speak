package com.chat.speak.services;

import com.chat.speak.model.ChatUser;
import com.chat.speak.model.Gender;
import com.chat.speak.repository.ChatUserRepository;
import com.chat.speak.repository.UserRoleRepository;
import com.chat.speak.util.Util;
import lombok.RequiredArgsConstructor;
import netscape.security.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Nikita Krutoguz
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChatUserService {
    private final ChatUserRepository chatUserRepository;
    private final UserRoleRepository userRoleRepository;


    public final ChatUser findUserByLogin(String name) {
        return chatUserRepository.findChatUserByLogin(name);
    }

    public final void save(ChatUser chatUser) {
         chatUserRepository.save(chatUser);
    }

    public final ChatUser findChatUserByToken(String token) {
        return chatUserRepository.findChatUserByToken(token);
    }

    public final SimpleMailMessage req(@RequestParam String login, @RequestParam String email, @RequestParam String password, final HttpServletRequest request){
        String newToken = UUID.randomUUID().toString();
        ChatUser chatUser = new ChatUser(login, email, Gender.MALE, new BCryptPasswordEncoder(10).encode(password),false,newToken);
        chatUser.setRole(userRoleRepository.findOne(1L));
        chatUserRepository.save(chatUser);
        String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + "/registrationConfirm.html?token=" + newToken;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Confirm Your Email");
        message.setText("Please go to this link " + appUrl);
        return message;
    }

}
