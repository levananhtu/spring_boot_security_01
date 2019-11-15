package lvat.springbootsecurity01.module04.repository;

import lvat.springbootsecurity01.module04.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
