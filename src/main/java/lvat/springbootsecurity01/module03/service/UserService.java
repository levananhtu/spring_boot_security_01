package lvat.springbootsecurity01.module03.service;

import lvat.springbootsecurity01.module03.model.User;
import lvat.springbootsecurity01.module03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email, User.class);
    }

    public Optional<User> findByUsernameOrEmail(String usernameOrEmail) {
        return userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail, User.class);
    }

    public List<User> findByIdIn(List<Long> userIds) {
        return userRepository.findByIdIn(userIds, User.class);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username, User.class);

    }

    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);

    }

    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
