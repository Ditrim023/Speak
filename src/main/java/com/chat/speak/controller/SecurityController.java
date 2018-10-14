package com.chat.speak.controller;

import com.chat.speak.model.ChatUser;
import com.chat.speak.model.Gender;
import com.chat.speak.repository.UserRoleRepository;
import com.chat.speak.services.ChatUserService;
import com.chat.speak.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

/**
 * @author Nikita Krutoguz
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityController {

    private final ChatUserService chatUserService;
    private final UserRoleRepository userRoleRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String register() {
        return "system/error";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String error() {
        return "system/register";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(final Model model) {
        final ChatUser currentUser = chatUserService.findUserByLogin(Util.getAuthorizedUserName());
        model.addAttribute("title", "Profile");
        model.addAttribute("currentUser", currentUser);
        return "system/profile";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public final String login() {
        return "/system/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public final String logout(final HttpServletRequest request, final HttpServletResponse response) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) new SecurityContextLogoutHandler().logout(request, response, authentication);
        return "redirect:/index";
    }

    @Autowired
    public JavaMailSender javaMailSend;

    @ResponseBody
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public final String registration(@RequestParam String login, @RequestParam String email, @RequestParam String password, final HttpServletRequest request) {
       final SimpleMailMessage  message = chatUserService.req(login,email,password,request);
        javaMailSend.send(message);
        return "<h1>Check your email</h1>";
   }

    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public final String registrationConfirm(final Model model,@RequestParam("token") final String token) {
        ChatUser chatUser = chatUserService.findChatUserByToken(token);
        if (chatUser == null){
            return "error";
        }
        chatUser.setConfirm(true);
        chatUserService.save(chatUser);
        model.addAttribute("currentUser", chatUser);
        return "/system/profile";
    }

}
