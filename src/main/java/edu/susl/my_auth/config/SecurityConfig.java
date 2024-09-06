package edu.susl.my_auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.susl.my_auth.entity.User;
import edu.susl.my_auth.service.UserService;

@Configuration
public class SecurityConfig {
	private UserService userService;
	
	public SecurityConfig(UserService userService) {
		this.userService = userService;
	}
	
//	should be clarified this part
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/login", "/").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }
	
	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
            User user = userService.findByUserName(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
        };
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
