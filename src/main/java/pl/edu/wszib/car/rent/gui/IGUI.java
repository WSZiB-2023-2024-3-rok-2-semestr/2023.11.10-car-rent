package pl.edu.wszib.car.rent.gui;

import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.User;

public interface IGUI {
    String showMenuAndReadChoose();
    void listCars(Car[] cars);
    void listVehicles();
    String readPlate();
    void showResult(boolean result);
    User readAuthData();
}
