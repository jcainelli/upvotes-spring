package br.com.jcainelli.upvotes.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.jcainelli.upvotes.uteis.InitializeDataBaseDesenv;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private InitializeDataBaseDesenv initializeDataBaseDesenv;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase() throws ParseException {

        if (!"create".equals(strategy)) {
            initializeDataBaseDesenv.instantiateDatabase();
        }
        return true;
    }

}
