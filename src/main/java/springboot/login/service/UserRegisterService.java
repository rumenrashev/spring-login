package springboot.login.service;

import springboot.login.service.models.UserRegisterModel;

public interface UserRegisterService {

    String registerUser(UserRegisterModel userRegisterModel);

}
