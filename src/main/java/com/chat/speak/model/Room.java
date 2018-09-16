package com.chat.speak.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Nikita Krutoguz
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String name;

    private String creatorLogin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private List<ChatUser> users;

    public Room(String name) {
        this.name = name;
    }
}
