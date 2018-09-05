package ac.daffodil.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Uzzal on 7/3/2018.
 */
//This Model Class is use for Password Reset.
public class PasswordForgotDto {
    @NotEmpty
    @Email
    private String email;

    public PasswordForgotDto() {
    }

    public PasswordForgotDto(@NotEmpty @Email String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
