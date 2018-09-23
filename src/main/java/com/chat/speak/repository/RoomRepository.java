package com.chat.speak.repository;

import com.chat.speak.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nikita Krutoguz
 */
@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
