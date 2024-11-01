package dev.allinone.libraryapp.repository.user;

import dev.allinone.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

public class UserJdbcRepository {

    private final JdbcClient jdbcClient;

    public UserJdbcRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void saveUser(String name, Integer age) {
        jdbcClient.sql("""
                        insert into user (name, age) values (:name, :age);
                        """)
                .param("name", name)
                .param("age", age)
                .update();
    }

    public List<UserResponse> getUsers() {
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

    public boolean isUserNotExist(Long id) {
        return jdbcClient.sql("""
                        select * from user where id = :id;
                        """)
                .param("id", id)
                .query((rs, rowNum) -> 0)
                .list().isEmpty();
    }

    public void updateUserName(String name, Long id) {
        jdbcClient.sql("""
                        update user set name = :name where id = :id;    
                        """)
                .param("name", name)
                .param("id", id)
                .update();
    }

    public boolean isUserNotExist(String name) {
        return jdbcClient.sql("""
                        select * from user where name = :name;
                        """)
                .param("name", name)
                .query((rs, rowNum) -> 0)
                .list().isEmpty();
    }

    public void deleteUser(String name) {
        jdbcClient.sql("""
                        delete from user where name = :name;
                        """)
                .param("name", name)
                .update();
    }

}
