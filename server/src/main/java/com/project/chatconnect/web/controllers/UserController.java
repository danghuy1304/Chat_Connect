package com.project.chatconnect.web.controllers;

import com.project.chatconnect.applications.services.users.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 *
 * @author Huy Dang
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("${api.version1}/users")
public class UserController {
    private final IUserService userService;


    /**
     * API test.
     *
     * @return the string
     */
    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

    /**
     * Login http response.
     *
     * @param username the username
     * @param password the password
     * @return the http response
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(String username, String password) {
        var res = userService.login(username, password);
        return ResponseEntity.status(200).body(res);
    }
}
