package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.User;

public interface IUserRepository {
    User getByLogin(String login);
}
