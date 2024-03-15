package pl.edu.wszib.car.rent.authorization;

import pl.edu.wszib.car.rent.model.User;

public interface IAuthenticator {
    void authenticate(User user);
    User getLoggedUser();
    void setLoggedUser(User loggedUser);
}
