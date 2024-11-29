package com.project.chatconnect.web.controllers;

import com.project.chatconnect.applications.services.users.IUserService;
import com.project.chatconnect.utility.GeneralLogUtility;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    private final GeneralLogUtility generalLogUtility;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * API test.
     *
     * @return the string
     */
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        Map<String, Object> details = new HashMap<>();
        details.put("name", "test");
        generalLogUtility.writeLog(logger, "Test", details);
        return ResponseEntity.status(200).body("Test API");
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
