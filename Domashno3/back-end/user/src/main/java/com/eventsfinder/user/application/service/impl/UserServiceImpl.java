package com.eventsfinder.user.application.service.impl;

import com.eventsfinder.user.application.service.UserService;
import com.eventsfinder.user.domain.model.ApplicationRole;
import com.eventsfinder.user.domain.model.ApplicationUser;
import com.eventsfinder.user.domain.repository.RoleRepository;
import com.eventsfinder.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = userRepository.findByUsername(username).orElseThrow(() -> {
            log.error("User not found in the database");
            return new UsernameNotFoundException(String.format("Username %s not found in the database", username));
        });
        return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    @Override
    public ApplicationUser saveUser(ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public ApplicationRole saveRole(ApplicationRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        ApplicationUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        ApplicationRole role = roleRepository.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public ApplicationUser getUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public List<ApplicationUser> getUsers() {
        return userRepository.findAll();
    }
}
