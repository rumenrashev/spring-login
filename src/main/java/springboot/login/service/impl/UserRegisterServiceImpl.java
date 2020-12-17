package springboot.login.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.login.constants.Roles;
import springboot.login.persistance.entities.User;
import springboot.login.persistance.repository.RoleRepository;
import springboot.login.persistance.repository.UserRepository;
import springboot.login.service.UserRegisterService;
import springboot.login.service.models.UserRegisterModel;

import java.util.Set;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRegisterServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                                   ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public String registerUser(UserRegisterModel userRegisterModel) {
        User user = this.modelMapper.map(userRegisterModel, User.class);
        user.setPassword(this.bCryptPasswordEncoder.encode(userRegisterModel.getPassword()));
        if (this.userRepository.count() == 0) {
            user.setAuthorities(this.roleRepository.getAllBy());
        } else {
            user.setAuthorities(Set.of(this.roleRepository.getByAuthority(Roles.USER.toString()).get()));
        }
        this.userRepository.saveAndFlush(user);
        return user.getUsername();
    }
}
