package springboot.login.service;

import springboot.login.persistance.entities.User;

import java.util.List;

public interface AdminService {

    List<User> showUsers();

    void deleteUser(Long id);

}
