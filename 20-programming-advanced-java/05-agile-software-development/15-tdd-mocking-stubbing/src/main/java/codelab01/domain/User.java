package codelab01.domain;

import java.util.UUID;

/**
 * Read the README.md.
 */
public class User {

    private final UUID id;
    private final String nickname;

    public User(String nickname) {
        this.id = UUID.randomUUID();
        this.nickname = nickname;
    }

    public UUID getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

}
