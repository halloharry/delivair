package com.delivair.module.user.controller;

import com.delivair.common.constant.CommonMessage;
import com.delivair.common.payload.response.BaseResponse;
import com.delivair.common.util.JwtUtil;
import com.delivair.model.User;
import com.delivair.module.user.payload.request.AuthRequest;
import com.delivair.module.user.payload.response.AuthResponse;
import com.delivair.repository.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to DelivAir";
    }

    @PostMapping("/login")
    public Object generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword())
            );
        } catch (Exception ex) {
            System.out.println(ex);
            return new BaseResponse(CommonMessage.NOT_FOUND);
        }
        System.out.println("token created!");
        String token = jwtUtil.generateToken(authRequest.getUsername());
        AuthResponse authResponse = new AuthResponse(authRequest.getUsername(), authRequest.getPassword(), "Bearer " + token);
        return new BaseResponse(CommonMessage.OK, authResponse);
    }

    @PostMapping("/register")
    public BaseResponse register(@RequestBody AuthRequest user) {
        try {
            String emailRgx = "^([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
            String passwordRgx = "^[a-zA-Z0-9@\\\\#$%&*()_+\\]\\[';:?.,!^-]{8,}$";

            boolean emailTrue = Pattern.matches(emailRgx, user.getUsername());
            boolean passwordTrue = Pattern.matches(passwordRgx, user.getPassword());

            if (emailTrue && passwordTrue) {
                userRepository.save(new User(user.getUsername(), user.getPassword()));
            } else {
                return new BaseResponse(CommonMessage.ERROR);
            }
        } catch (Exception e) {
            System.out.println("error = " + e);
            return new BaseResponse(CommonMessage.ERROR);
        }
        return new BaseResponse(CommonMessage.OK, user.getUsername());
    }
}
