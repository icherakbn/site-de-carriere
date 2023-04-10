package ma.enset.clientmvc;

import ma.enset.clientmvc.entites.Client;
import ma.enset.clientmvc.repositories.ClientRepository;
import ma.enset.clientmvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class ClientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository){
        return args -> {
            clientRepository.save(
                    new Client(null,"benkarra","halima",new Date()));
            clientRepository.save(
                    new Client(null,"boumahdi","sofiane",new Date()));
            clientRepository.save(
                    new Client(null,"benamara","ichrak",new Date()));

            clientRepository.findAll().forEach(c->{
                    System.out.println(c.getNom());
            });
        };
    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("mohamed","1234","1234");
            securityService.saveNewUser("yasmine","1234","1234");
            securityService.saveNewUser("racime","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("mohamed","USER");
            securityService.addRoleToUser("mohamed","ADMIN");
            securityService.addRoleToUser("yasmine","USER");
            securityService.addRoleToUser("racime","USER");
        };
    }
}

