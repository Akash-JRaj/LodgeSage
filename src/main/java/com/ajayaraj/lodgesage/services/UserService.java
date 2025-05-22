package com.ajayaraj.lodgesage.services;

import com.ajayaraj.lodgesage.models.User;
import com.ajayaraj.lodgesage.repositories.UserRepository;
import com.ajayaraj.lodgesage.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository,
                       AuthenticationManager authenticationManager,
                       JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public User register(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String login(User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtUtil.generateToken(user.getUsername());
        } else {
            return "Login failed";
        }
    }

}
