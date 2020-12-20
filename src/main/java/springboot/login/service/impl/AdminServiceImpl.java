package springboot.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.login.persistance.entities.User;
import springboot.login.persistance.repository.UserRepository;
import springboot.login.service.AdminService;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @Autowired
    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> showUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

}
