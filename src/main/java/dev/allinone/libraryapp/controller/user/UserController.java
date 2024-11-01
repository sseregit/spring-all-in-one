package dev.allinone.libraryapp.controller.user;

import dev.allinone.libraryapp.dto.user.request.UserCreateRequest;
import dev.allinone.libraryapp.dto.user.request.UserUpdateRequest;
import dev.allinone.libraryapp.dto.user.response.UserResponse;
import dev.allinone.libraryapp.service.fruit.FruitService;
import dev.allinone.libraryapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
record UserController(
        UserService userService,
        @Qualifier("main")
        FruitService fruitService
) {

    @PostMapping("/user")
    void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    void deleteUser(String name) {
        userService.deleteUser(name);
    }

}
