package pl.edu.wszib.car.rent.authorization;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.db.impl.UserRepository;
import pl.edu.wszib.car.rent.model.User;

public class Authenticator implements IAuthenticator {

    @Autowired
    private UserRepository userRepository;

    private final String SEED = "oGvZxgE'i0E+%qnVm7$#AZGL%x3Bua";
    private User loggedUser = null;

    public void authenticate(User user) {
        User userFromDB = userRepository.getByLogin(user.getLogin());
        if(userFromDB != null &&
                userFromDB.getPassword().equals(DigestUtils.md5Hex(user.getPassword()+SEED))) {
            this.loggedUser = userFromDB;
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
}
