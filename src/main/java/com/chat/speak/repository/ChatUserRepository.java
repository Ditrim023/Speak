package com.chat.speak.repository;

import com.chat.speak.model.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Nikita Krutoguz
 */
@Repository
public interface ChatUserRepository extends JpaRepository<ChatUser,Long> {
    @Query(value = "SELECT u FROM ChatUser u WHERE u.login = :login")
    ChatUser findChatUserByLogin(final @Param("login") String login);

    @Query(value = "SELECT u FROM ChatUser u WHERE u.token = :token")
    ChatUser findChatUserByToken(final @Param("token") String token);
}
