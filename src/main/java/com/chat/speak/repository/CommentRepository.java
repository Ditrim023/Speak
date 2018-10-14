package com.chat.speak.repository;

import com.chat.speak.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nikita Krutoguz
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
