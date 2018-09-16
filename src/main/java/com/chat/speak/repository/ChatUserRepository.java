package com.chat.speak.repository;

import com.chat.speak.model.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nikita Krutoguz
 */
@Repository
public interface ChatUserRepository extends JpaRepository<ChatUser,Long>{
}
