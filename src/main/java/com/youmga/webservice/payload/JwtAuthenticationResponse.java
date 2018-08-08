package com.youmga.webservice.payload;

import lombok.Builder;
import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String accessToken;

    private String tokenType = "Bearer";

    @Builder
    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
