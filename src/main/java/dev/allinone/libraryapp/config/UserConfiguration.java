package dev.allinone.libraryapp.config;

import dev.allinone.libraryapp.repository.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository userRepository(JdbcClient jdbcClient) {
        return new UserRepository(jdbcClient);
    }
}
