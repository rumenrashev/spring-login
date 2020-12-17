package springboot.login.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.login.persistance.entities.Role;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> getByAuthority(String authority);

    Set<Role> getAllBy();

}
