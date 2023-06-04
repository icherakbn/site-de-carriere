package ma.enset.careerwebsite.service;

import ma.enset.careerwebsite.model.User;
import ma.enset.careerwebsite.web.UserSignUpDto;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    @Bean
    User save(UserSignUpDto SignInDto);
}
