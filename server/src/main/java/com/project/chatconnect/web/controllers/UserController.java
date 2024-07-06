package com.project.chatconnect.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 * Author: Huy Dang
 */
@RestController
@RequestMapping("${api.version1}/users")
public class UserController {
    /**
     * API test.
     *
     * @return the string
     */
    @GetMapping("/test")
    public String hello() {
        return "Hello";
    }
}
