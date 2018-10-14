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
    @Column(nullable = false)
    private String email;
//    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private Status status = Status.OFFLINE;
    @Column(nullable = false)
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private UserRole role;
    private Boolean confirm;
    private String token;

    public ChatUser(String login, String email, Gender gender) {
        this.login = login;
        this.email = email;
        this.gender = gender;
    }

    public ChatUser(String login, String email, Gender gender, String password) {
        this.login = login;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public ChatUser(String login, String email, Gender gender, String password, Boolean confirm, String token) {
        this.login = login;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.confirm = confirm;
        this.token = token;
    }
}
