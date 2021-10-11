package com.delivair.module.user.payload.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponse {
    String username;
    String password;
    String token;
}
