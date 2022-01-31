package com.eventsfinder.user.api;

import com.eventsfinder.user.application.service.UserService;
import com.eventsfinder.user.domain.model.ApplicationRole;
import com.eventsfinder.user.domain.model.ApplicationUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<ApplicationUser>> getUsers() {
        return ResponseEntity
                .ok()
                .body(this.userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<ApplicationUser> saveUser(
            @RequestBody ApplicationUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity
                .created(uri)
                .body(this.userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<ApplicationRole> saveRole(
            @RequestBody ApplicationRole role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity
                .created(uri)
                .body(this.userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(
            @RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity
                .ok()
                .build();
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}

