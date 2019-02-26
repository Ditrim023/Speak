package com.chat.speak.repository;

import com.chat.speak.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Nikita Krutoguz
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query(value = "SELECT u FROM Comment u WHERE u.roomId = :roomId")
    List<Comment> findAllUserByRoleId(final @Param("roomId") Long roomId);
}
