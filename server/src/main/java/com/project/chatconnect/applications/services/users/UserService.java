package com.project.chatconnect.applications.services.users;

import com.project.chatconnect.applications.repositories.UserRepository;
import com.project.chatconnect.configs.security.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final CustomUserDetailService customUserDetailService;

    @Override
    public String login(String userName, String password) {

        return "";
    }
}
