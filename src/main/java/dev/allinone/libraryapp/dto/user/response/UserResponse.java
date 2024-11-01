package dev.allinone.libraryapp.dto.user.response;

import dev.allinone.libraryapp.domain.user.User;

public record UserResponse(
        Long id,
        String name,
        Integer age
) {

    public UserResponse(Long id, User user) {
        this(id, user.getName(), user.getAge());
    }

    public UserResponse(User user) {
        this(user.getId(), user.getName(), user.getAge());
    }
}
