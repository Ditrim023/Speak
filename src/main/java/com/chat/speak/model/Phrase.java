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
public class Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String text;

    public Phrase(String text) {
        this.text = text;
    }
}
