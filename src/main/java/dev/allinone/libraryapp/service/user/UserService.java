package dev.allinone.libraryapp.service.user;

import dev.allinone.libraryapp.dto.user.request.UserCreateRequest;
import dev.allinone.libraryapp.dto.user.request.UserUpdateRequest;
import dev.allinone.libraryapp.dto.user.response.UserResponse;
import dev.allinone.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(JdbcClient jdbcClient) {
        userRepository = new UserRepository(jdbcClient);
    }

    public void saveUser(UserCreateRequest request) {
        userRepository.saveUser(request.name(), request.age());
    }

    public List<UserResponse> getUsers() {
        return userRepository.getUsers();
    }

    public void updateUser(UserUpdateRequest request) {
        if (userRepository.isUserNotExist(request.id())) {
            throw new IllegalArgumentException();
        }

        userRepository.updateUserName(request.name(), request.id());

    }

    public void deleteUser(String name) {
        if (userRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }

        userRepository.deleteUser(name);
    }

}
