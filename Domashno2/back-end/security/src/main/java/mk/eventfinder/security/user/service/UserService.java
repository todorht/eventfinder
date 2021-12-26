package mk.eventfinder.security.user.service;

import mk.eventfinder.security.user.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    boolean registerUser(UserDto user);
}
