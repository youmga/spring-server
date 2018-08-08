package com.youmga.webservice.payload;

import lombok.Builder;
import lombok.Data;

@Data
public class UserIdentityAvailability {

    private Boolean available;

    @Builder
    public UserIdentityAvailability(Boolean available) {
        this.available = available;
    }
}
