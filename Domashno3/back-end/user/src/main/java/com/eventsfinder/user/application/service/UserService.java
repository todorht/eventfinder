package com.eventsfinder.user.application.service;

import com.eventsfinder.user.domain.model.ApplicationRole;
import com.eventsfinder.user.domain.model.ApplicationUser;

import java.util.List;

public interface UserService {
    ApplicationUser saveUser(ApplicationUser user);
    ApplicationRole saveRole(ApplicationRole role);
    void addRoleToUser(String username, String roleName);
    ApplicationUser getUser(String username);
    List<ApplicationUser> getUsers();
}
