package com.spring.main.jwt.controller;

import com.spring.main.jwt.dto.LoginRequest;
import com.spring.main.jwt.entity.JwtRequest;
import com.spring.main.jwt.entity.JwtResponse;
import com.spring.main.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class JwtController {

    @Autowired
    private JwtService jwtService;

//    @PostMapping({"/login"})
//    public JwtResponse createJwtToken (@RequestBody JwtRequest jwtRequest) throws Exception {
//
////        (@RequestBody JwtRequest jwtRequest)
////        JwtRequest jwtRequest = new JwtRequest();
//
//        return jwtService.createJwtToken(jwtRequest);
//    }



    @PostMapping({"/signin"})
    public JwtResponse createJwtToken22(@RequestBody LoginRequest loginRequest) throws Exception {
        System.out.println("Test Action");
//        (@RequestBody JwtRequest jwtRequest)
        JwtRequest jwtRequest = new JwtRequest();

        jwtRequest.setUserName(loginRequest.getUsername());
        jwtRequest.setUserPassword(loginRequest.getPassword());


        return jwtService.createJwtToken(jwtRequest);
    }

}
