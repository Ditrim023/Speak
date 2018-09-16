package com.chat.speak.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Nikita Krutoguz
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ChatUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false)
    private String login;

    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;
}
