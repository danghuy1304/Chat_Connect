package com.project.chatconnect.configs.security;

import com.project.chatconnect.applications.repositories.UserRepository;
import com.project.chatconnect.configs.messages.MessageKeys;
import com.project.chatconnect.domains.enities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The type Custom user detail service.
 * Author: Huy Dang
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    /**
     * Load user details user details.
     *
     * @param username the username
     * @return the user details
     * @throws UsernameNotFoundException the username not found exception
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(MessageKeys.USER_NOT_FOUND));
        return new CustomUserDetails(user);
    }
}
