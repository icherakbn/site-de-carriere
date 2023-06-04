package ma.enset.careerwebsite.config;

import ma.enset.careerwebsite.repository.UserRepository;
import ma.enset.careerwebsite.service.UserService;
import ma.enset.careerwebsite.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration

public class ServiceConfig {
    private BCryptPasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    @Bean
    public UserService userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setPasswordEncoder(passwordEncoder);
        userService.setUserRepository(userRepository);
        return userService;
    }
}
