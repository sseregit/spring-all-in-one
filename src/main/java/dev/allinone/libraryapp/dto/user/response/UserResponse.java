package dev.allinone.libraryapp.dto.user.response;

import dev.allinone.libraryapp.domain.user.User;

public record UserResponse(
        Long id,
        String name,
        Integer age
) {

    public UserResponse(Long id, User user) {
        this(id, user.name(), user.age());
    }
}
