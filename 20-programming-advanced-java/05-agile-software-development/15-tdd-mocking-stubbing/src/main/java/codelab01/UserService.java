package codelab01;

import codelab01.domain.User;
import codelab01.domain.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Read the README.md.
 * These are the 3 public methods (API) you should test
 */
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.add(user);
    }

    public User getUser(UUID userId) {
        return userRepository.getForId(userId);
    }

    public List<User> getUsersSortedOnNicknameAsc() {
        return userRepository.getAll().stream()
                .sorted(Comparator.comparing(User::getNickname))
                .collect(Collectors.toList());
    }
}
