package com.chat.speak;

import com.chat.speak.model.ChatUser;
import com.chat.speak.model.Gender;
import com.chat.speak.model.Room;
import com.chat.speak.model.UserRole;
import com.chat.speak.repository.ChatUserRepository;
import com.chat.speak.repository.RoomRepository;
import com.chat.speak.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Nikita Krutoguz
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataLoader implements ApplicationRunner {
    private final RoomRepository roomRepository;
    private final ChatUserRepository chatUserRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserRole admin = new UserRole("ROLE_ADMIN");
    private final UserRole chatUser = new UserRole("ROLE_USER");
    final List<Room> roomList = new ArrayList<>();
    final List<ChatUser> chatUsers = new ArrayList<>();

    @Override
    public void run(ApplicationArguments applicationArguments) {
        insertRoles();
        insertRooms();
        insertUsers();
    }

    public void insertUsers() {
        ChatUser chatUser1 = new ChatUser("user0", "ditrim023@ukr.net", Gender.MALE,new BCryptPasswordEncoder(10).encode("123456"),true, UUID.randomUUID().toString());
        chatUser1.setRole(userRoleRepository.findOne(1L));
        chatUsers.add(chatUser1);
        ChatUser chatUser2 = new ChatUser("Naram", "ditrim020@ukr.net", Gender.FEMALE,new BCryptPasswordEncoder(10).encode("123456"),true,UUID.randomUUID().toString());
        chatUser2.setRole(userRoleRepository.findOne(2L));
        chatUsers.add(chatUser2);
        chatUserRepository.save(chatUsers);

    }
    public void insertRoles(){
        userRoleRepository.save(admin);
        userRoleRepository.save(chatUser);
    }

    public void insertRooms() {
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
//        roomList.add(new Room("First"));
//        roomList.add(new Room("Second"));
//        roomList.add(new Room("Third"));
//        roomList.add(new Room("Four"));
        roomRepository.save(roomList);
    }
}
