package dev.allinone.libraryapp.domain.user;

import java.util.Objects;

public record User(
        String name,
        Integer age
) {

    public User {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
    }
}
