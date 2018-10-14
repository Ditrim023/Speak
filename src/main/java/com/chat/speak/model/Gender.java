package com.chat.speak.model;

import lombok.Getter;

/**
 * @author Nikita Krutoguz
 */
@Getter
public enum Gender {
    MALE("male"), FEMALE("female");
    private String gender;
    Gender(String gender){
        this.gender = gender;
    }
}
