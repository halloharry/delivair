package com.delivair.service.impl;

import com.delivair.model.User;
import com.delivair.repository.UserRepository;
import com.delivair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

    @Autowired
    UserRepository userRepository;

    public String forgotPassword(String username) throws IOException {

        User user = userRepository.findByUsername(username);
        System.out.println(user.getUsername());

        if (user.getUsername().equals(null)) {
            return "Invalid email id.";
        }

        userRepository.save(user);
        return user.getUsername();
    }

    public String resetPassword(String token, String password) throws IOException {

        Optional<User> userOptional = Optional
                .ofNullable(userRepository.findByUsername(token));

        if (!userOptional.isPresent()) {
            return "Invalid token.";
        }

        User user = userOptional.get();
        user.setPassword(password);
        userRepository.save(user);

        return "Your password successfully updated.";
    }

    /**
     * Generate unique token. You may add multiple parameters to create a strong
     * token.
     *
     * @return unique token
     */
    private String generateToken() {
        StringBuilder token = new StringBuilder();

        return token.append(UUID.randomUUID().toString())
                .append(UUID.randomUUID().toString()).toString();
    }

    /**
     * Check whether the created token expired or not.
     *
     * @param tokenCreationDate
     * @return true or false
     */
    private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate, now);

        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }
}
