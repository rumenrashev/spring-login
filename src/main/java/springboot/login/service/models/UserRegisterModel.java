package springboot.login.service.models;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserRegisterModel {

    private String username;
    private String password;
    private String passwordConfirm;

    public UserRegisterModel() {
    }

    @Length(min = 8,max = 20,message = "Username must be between 8 and 20 characters!")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Length(min = 8,max = 16, message = "Password must be between 8 and 16 characters!")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Length(min = 8,message = "Min len 8")
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
