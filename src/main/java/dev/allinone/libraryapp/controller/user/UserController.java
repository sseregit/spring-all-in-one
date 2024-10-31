package dev.allinone.libraryapp.controller.user;

import dev.allinone.libraryapp.dto.user.request.UserCreateRequest;
import dev.allinone.libraryapp.dto.user.request.UserUpdateRequest;
import dev.allinone.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/user")
    void updateUser(@RequestBody UserUpdateRequest request) {
        boolean isUserNotExist = jdbcClient.sql("""
                        select * from user where id = :id;
                        """)
                .param("id", request.id())
                .query((rs, rowNum) -> 0)
                .list().isEmpty();

        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        jdbcClient.sql("""
                        update user set name = :name where id = :id;    
                        """)
                .param("name", request.name())
                .param("id", request.id())
                .update();
    }

    @DeleteMapping("/user")
    void deleteUser(String name) {
        boolean isUserNotExist = jdbcClient.sql("""
                        select * from user where name = :name;
                        """)
                .param("name", name)
                .query((rs, rowNum) -> 0)
                .list().isEmpty();

        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        jdbcClient.sql("""
                        delete from user where name = :name;
                        """)
                .param("name", name)
                .update();
    }

}
