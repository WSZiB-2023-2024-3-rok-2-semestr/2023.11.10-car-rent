package pl.edu.wszib.car.rent.db.impl;

import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.db.IUserRepository;
import pl.edu.wszib.car.rent.model.User;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository implements IUserRepository {
    private final Map<String, User> users = new HashMap<>();

    public UserRepository() {
        this.users.put("admin",
                new User("admin", "362706cff716326a8a8317c9c5bd47f9", "ADMIN"));
        this.users.put("janusz",
                new User("janusz", "5550b60e1d08b7c2e88d146c0721de00", "USER"));
    }

    public User getByLogin(String login) {
        return this.users.get(login);
    }
}
