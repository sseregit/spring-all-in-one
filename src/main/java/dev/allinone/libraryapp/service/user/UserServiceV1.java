package dev.allinone.libraryapp.service.user;

import dev.allinone.libraryapp.dto.user.request.UserCreateRequest;
import dev.allinone.libraryapp.dto.user.request.UserUpdateRequest;
import dev.allinone.libraryapp.dto.user.response.UserResponse;
import dev.allinone.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(UserCreateRequest request) {
        userJdbcRepository.saveUser(request.name(), request.age());
    }

    public List<UserResponse> getUsers() {
        return userJdbcRepository.getUsers();
    }

    public void updateUser(UserUpdateRequest request) {
        if (userJdbcRepository.isUserNotExist(request.id())) {
            throw new IllegalArgumentException();
        }

        userJdbcRepository.updateUserName(request.name(), request.id());

    }

    public void deleteUser(String name) {
        if (userJdbcRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }

        userJdbcRepository.deleteUser(name);
    }

}
