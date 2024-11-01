package dev.allinone.libraryapp.config;

import dev.allinone.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;

@Configuration
public class UserConfiguration {

    @Bean
    public UserJdbcRepository userJdbcRepository(JdbcClient jdbcClient) {
        return new UserJdbcRepository(jdbcClient);
    }
}
