package dev.allinone.libraryapp.controller.user;

import dev.allinone.libraryapp.dto.user.request.UserCreateRequest;
import dev.allinone.libraryapp.dto.user.request.UserUpdateRequest;
import dev.allinone.libraryapp.dto.user.response.UserResponse;
import dev.allinone.libraryapp.service.user.UserServiceV1;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
record UserController(
        UserServiceV1 userServiceV1
) {

    @PostMapping("/user")
    void saveUser(@RequestBody UserCreateRequest request) {
        userServiceV1.saveUser(request);
    }

    @GetMapping("/user")
    List<UserResponse> getUsers() {
        return userServiceV1.getUsers();
    }

    @PutMapping("/user")
    void updateUser(@RequestBody UserUpdateRequest request) {
        userServiceV1.updateUser(request);
    }

    @DeleteMapping("/user")
    void deleteUser(String name) {
        userServiceV1.deleteUser(name);
    }

}
