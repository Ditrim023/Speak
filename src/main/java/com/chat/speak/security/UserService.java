package com.chat.speak.security;


import com.chat.speak.model.ChatUser;
import com.chat.speak.model.Status;
import com.chat.speak.repository.ChatUserRepository;
import com.chat.speak.services.ChatUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements UserDetailsService {

    private final ChatUserService chatUserService;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        final ChatUser user = chatUserService.findUserByLogin(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User " + userName + " does not exist");
        }
        Set<GrantedAuthority> roles = new HashSet<>();
        user.setStatus(Status.ONLINE);
        chatUserService.save(user);
        roles.add(new SimpleGrantedAuthority(user.getRole().getRole()));
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
    }

}
