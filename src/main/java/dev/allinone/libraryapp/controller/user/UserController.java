package dev.allinone.libraryapp.controller.user;

import dev.allinone.libraryapp.dto.user.request.UserCreateRequest;
import dev.allinone.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class UserController {

    private final JdbcClient jdbcClient;

    public UserController(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @PostMapping("/user")
    void saveUser(@RequestBody UserCreateRequest request) {
        jdbcClient.sql("""
                        insert into user (name, age) values (:name, :age);
                        """)
                .param("name", request.name())
                .param("age", request.age())
                .update();
    }

    @GetMapping("/user")
    List<UserResponse> getUsers() {
        return jdbcClient.sql("""
                        select * from user;
                        """)
                .query((rs, rowNum) -> {
                    Long id = rs.getLong("id");
                    String name = rs.getString("name");
                    Integer age = rs.getInt("age");
                    return new UserResponse(id, name, age);
                }).list();
    }


}
