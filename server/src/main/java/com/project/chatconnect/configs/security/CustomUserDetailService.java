package com.project.chatconnect.configs.security;

import com.project.chatconnect.applications.repositories.UserRepository;
import com.project.chatconnect.configs.messages.MessageKeys;
import com.project.chatconnect.domains.enities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(MessageKeys.USER_NOT_FOUND));
        return new CustomUserDetails(user);
    }
}
