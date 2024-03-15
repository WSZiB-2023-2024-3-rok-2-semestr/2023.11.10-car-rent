package pl.edu.wszib.car.rent.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.model.User;

public class AuthenticatorV3 implements IAuthenticator {
    @Override
    public void authenticate(User user) {

    }

    @Override
    public User getLoggedUser() {
        return null;
    }

    @Override
    public void setLoggedUser(User loggedUser) {

    }
}
