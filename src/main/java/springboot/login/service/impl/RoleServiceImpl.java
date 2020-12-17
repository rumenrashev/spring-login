package springboot.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.login.constants.Roles;
import springboot.login.persistance.entities.Role;
import springboot.login.persistance.repository.RoleRepository;
import springboot.login.service.RoleService;

import java.util.EnumSet;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        this.seedRoles();
    }

    private void seedRoles(){
        EnumSet<Roles> roles = EnumSet.allOf(Roles.class);
        roles
                .stream()
                .map(Enum::toString)
                .forEach(r->{
                    if (this.roleRepository.getByAuthority(r).isEmpty()){
                        this.roleRepository.saveAndFlush(new Role(r));
                    }
                });
    }
}
