package com.chat.speak.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nikita Krutoguz
 */
@Getter
@Setter
@NoArgsConstructor
public class CommentJsonData {
    private String author;
    private String text;
}
