package dev.allinone.libraryapp.service.user;

import dev.allinone.libraryapp.domain.user.User;
import dev.allinone.libraryapp.domain.user.UserRepository;
import dev.allinone.libraryapp.dto.user.request.UserCreateRequest;
import dev.allinone.libraryapp.dto.user.request.UserUpdateRequest;
import dev.allinone.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.name(), request.age()));
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getAge()))
                .toList();
    }

    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.id())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.name());

        userRepository.save(user);
    }

    public void deleteUser(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }
}
