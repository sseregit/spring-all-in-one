package dev.allinone.libraryapp.dto.user.request;

public record UserCreateRequest(
        String name,
        Integer age
) {
}
