package com.chat.speak.repository;

import com.chat.speak.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nikita Krutoguz
 */
@Repository
public interface RoomRepository extends JpaRepository<Room,Long>{
}
