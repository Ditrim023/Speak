package com.chat.speak.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Nikita Krutoguz
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String role;
    @OneToMany(mappedBy = "role")
    private List<ChatUser> user;

    public UserRole(String role) {
        this.role = role;
    }

}
