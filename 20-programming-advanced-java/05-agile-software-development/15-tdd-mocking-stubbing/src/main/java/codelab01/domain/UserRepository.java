package codelab01.domain;

import java.util.*;

/**
 * Read the README.md.
 */
public class UserRepository {

    // usersDB is a very dummy in-memory database
    private final Map<UUID, User> usersDB;

    public UserRepository() {
        usersDB = new HashMap<>();
    }

    public UserRepository(Map<UUID, User> usersDB) {
        this.usersDB = usersDB;
    }

    public void add(User user) {
        usersDB.put(user.getId(), user);
    }

    public User getForId(UUID userId) {
        return usersDB.get(userId);
    }

    public List<User> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(usersDB.values()));
    }
}
