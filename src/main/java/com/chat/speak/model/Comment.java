package com.chat.speak.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @author Nikita Krutoguz
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;

    private String author;

    public Comment(String text) {
        this.text = text;
    }

    public Comment(String text, Room room) {
        this.text = text;
        this.room = room;
    }

    public Comment(String text, Room room, String author) {
        this.text = text;
        this.room = room;
        this.author = author;
    }
}
