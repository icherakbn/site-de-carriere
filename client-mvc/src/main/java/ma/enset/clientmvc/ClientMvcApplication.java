package ma.enset.clientmvc;

import ma.enset.clientmvc.entites.Client;
import ma.enset.clientmvc.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ClientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientMvcApplication.class, args);
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

            clientRepository.findAll().forEach(c-> System.out.println(c.getNom()));

        };
    }

}

