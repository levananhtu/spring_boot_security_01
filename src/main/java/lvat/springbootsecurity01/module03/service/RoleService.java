package lvat.springbootsecurity01.module03.service;

import lvat.springbootsecurity01.module03.model.Role;
import lvat.springbootsecurity01.module03.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findByName(Role.RoleName roleName) {
        return roleRepository.findByName(roleName);
    }
}
