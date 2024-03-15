package pl.edu.wszib.car.rent.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.car.rent.authorization.Authenticator;
import pl.edu.wszib.car.rent.authorization.IAuthenticator;

@Configuration
@ComponentScan({
        "pl.edu.wszib.car.rent.authorization",
        "pl.edu.wszib.car.rent.core",
        "pl.edu.wszib.car.rent.db",
        "pl.edu.wszib.car.rent.gui"})
public class AppConfiguration {

    @Bean
    public IAuthenticator authenticator() {
        return new Authenticator();
    }
}
