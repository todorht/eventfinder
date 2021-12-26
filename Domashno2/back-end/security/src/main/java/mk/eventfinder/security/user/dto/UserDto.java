package mk.eventfinder.security.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class UserDto {

    @NotEmpty
    public String username;
    @NotEmpty
    public String firstname;
    @NotEmpty
    public String lastname;
    @NotEmpty
    @Email
    public String email;
    @NotEmpty
    public String password;
    @NotEmpty
    private String confirmPassword;

}
