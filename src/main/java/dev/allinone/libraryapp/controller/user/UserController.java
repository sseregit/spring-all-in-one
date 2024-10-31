package dev.allinone.libraryapp.controller.user;

import dev.allinone.libraryapp.domain.user.User;
import dev.allinone.libraryapp.dto.user.request.UserCreateRequest;
import dev.allinone.libraryapp.dto.user.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
class UserController {

    private final List<User> users = new CopyOnWriteArrayList<>();

    @PostMapping("/user")
    void saveUser(@RequestBody UserCreateRequest request) {
        users.add(new User(request.name(), request.age()));
    }

    @GetMapping("/user")
    List<UserResponse> getUsers() {
        List<UserResponse> reponses = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            reponses.add(new UserResponse((long) (i + 1), users.get(i)));
        }

        return reponses;
    }


}
