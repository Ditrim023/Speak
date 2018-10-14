package com.chat.speak.repository;

import com.chat.speak.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Nikita Krutoguz
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
