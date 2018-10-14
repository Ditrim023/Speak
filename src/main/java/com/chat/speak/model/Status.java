package com.chat.speak.model;

import lombok.Getter;

/**
 * @author Nikita Krutoguz
 */
@Getter
public enum Status {
    ONLINE("online"), OFFLINE("offline");
    private String status;
    Status(String status){
        this.status = status;
    }
}
