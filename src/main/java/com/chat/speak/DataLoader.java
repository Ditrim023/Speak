package com.chat.speak;

import com.chat.speak.model.Room;
import com.chat.speak.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Krutoguz
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataLoader implements ApplicationRunner {
    private final RoomRepository roomRepository;

    final List<Room> roomList = new ArrayList<>();

    @Override
    public void run(ApplicationArguments applicationArguments) {
         insertRooms();
    }

    public void insertRooms(){
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomList.add(new Room("First"));
        roomList.add(new Room("Second"));
        roomList.add(new Room("Third"));
        roomList.add(new Room("Four"));
        roomRepository.save(roomList);
    }
}
