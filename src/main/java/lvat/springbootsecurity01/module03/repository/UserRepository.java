package lvat.springbootsecurity01.module03.repository;

import lvat.springbootsecurity01.module03.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    <T> Optional<T> findByEmail(String email, Class<T> type);

    <T> Optional<T> findByUsernameOrEmail(String username, String email, Class<T> type);

    <T> List<T> findByIdIn(List<Long> userIds, Class<T> type);

    <T> Optional<T> findByUsername(String username, Class<T> type);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
