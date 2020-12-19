package springboot.login.service;

import org.springframework.validation.BindingResult;
import springboot.login.service.models.UserRegisterModel;

public interface UserRegisterService {

    String registerUser(UserRegisterModel userRegisterModel,BindingResult bindingResult);

    void checkUsernameIsFree(UserRegisterModel userRegisterModel, BindingResult bindingResult);

}
