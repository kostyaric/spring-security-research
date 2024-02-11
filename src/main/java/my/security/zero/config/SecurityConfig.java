package my.security.zero.config;

import my.security.zero.service.DbUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DbUserDetailsService userDetails;

    public SecurityConfig(DbUserDetailsService userDetails) {
        this.userDetails = userDetails;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated())
                .userDetailsService(userDetails)
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

/*
    @Bean
    public PasswordEncoder noOpPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
*/

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsService(UserDetails userDetails) {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("u")
                .password("1")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
*/
}
