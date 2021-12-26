package mk.eventfinder.security.user.service;

import mk.eventfinder.security.user.dto.UserDto;
import mk.eventfinder.security.user.exceptions.UserAlreadyExistsException;
import mk.eventfinder.security.user.model.EventFinderUser;
import mk.eventfinder.security.user.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;


@Service
public class UserDetailsServiceNoSql implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserDetailsServiceNoSql(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;

    }

    @PostConstruct
    void init(){
        this.userRepository.save(new EventFinderUser("todor","tode","tdorovski","tode@koj.com", encoder.encode("password")));
        var user = this.userRepository.findById("todor");
        System.out.println(user.get().email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EventFinderUser> user = this.userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return User.withUsername(user.get().username).password(user.get().username).roles("USER").build();
    }


    @Override
    public boolean registerUser(UserDto user) {
        if (userRepository.findById(user.getUsername()).isPresent()){
            throw new UserAlreadyExistsException(user.getUsername());
        } else if(userRepository.findEventFinderUserByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyExistsException(user.getEmail());
        }
        EventFinderUser newUser = new EventFinderUser(user.getUsername(),user.getFirstname(),
                user.getUsername(),user.getEmail(), encoder.encode(user.password));
        userRepository.save(newUser);
        return true;
    }
}
