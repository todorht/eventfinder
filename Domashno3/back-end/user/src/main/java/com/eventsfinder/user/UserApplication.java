package com.eventsfinder.user;

import com.eventsfinder.user.application.service.UserService;
import com.eventsfinder.user.domain.model.ApplicationRole;
import com.eventsfinder.user.domain.model.ApplicationUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new ApplicationRole(null, "ROLE_USER"));
            userService.saveRole(new ApplicationRole(null, "ROLE_MANAGER"));
            userService.saveRole(new ApplicationRole(null, "ROLE_ADMIN"));
            userService.saveRole(new ApplicationRole(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new ApplicationUser(null, "Jordan Ivanov", "jordan", "password", new ArrayList<>(), true, true, true, true));
            userService.saveUser(new ApplicationUser(null, "Nikola Gruevski", "nikola", "password", new ArrayList<>(), true, true, true, true));
            userService.saveUser(new ApplicationUser(null, "Zoran Zaev", "zoran", "password", new ArrayList<>(), true, true, true, true));
            userService.saveUser(new ApplicationUser(null, "Hristijan Mickovski", "hristijan", "password", new ArrayList<>(), true, true, true, true));

            userService.addRoleToUser("jordan", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("jordan", "ROLE_ADMIN");
            userService.addRoleToUser("jordan", "ROLE_USER");
            userService.addRoleToUser("nikola", "ROLE_MANAGER");
            userService.addRoleToUser("nikola", "ROLE_USER");
            userService.addRoleToUser("zoran", "ROLE_USER");
            userService.addRoleToUser("hristijan", "ROLE_ADMIN");
        };
    }

}
