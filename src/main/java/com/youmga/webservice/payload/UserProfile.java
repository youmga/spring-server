package com.youmga.webservice.payload;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserProfile {

    private Long id;

    private String username;

    private String name;

    private LocalDateTime joinedAt;

    @Builder
    public UserProfile(Long id, String username, String name, LocalDateTime joinedAt) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.joinedAt = joinedAt;
    }
}
