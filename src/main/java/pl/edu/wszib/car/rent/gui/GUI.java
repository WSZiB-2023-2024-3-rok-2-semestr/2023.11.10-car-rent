package pl.edu.wszib.car.rent.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.authorization.Authenticator;
import pl.edu.wszib.car.rent.authorization.AuthenticatorV2;
import pl.edu.wszib.car.rent.authorization.IAuthenticator;
import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.db.impl.VehicleRepository;
import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.LuxuryCar;
import pl.edu.wszib.car.rent.model.User;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.Scanner;

@Component
public class GUI implements IGUI {
    private final static Scanner scanner = new Scanner(System.in);
    @Autowired
    private IAuthenticator authenticator;
    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public String showMenuAndReadChoose() {
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Return car");
        System.out.println("4. Exit");
        return scanner.nextLine();
    }

    @Override
    public void listCars(Car[] cars) {
        for(Car car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public void listVehicles() {
        for(Vehicle vehicle : this.vehicleRepository.getVehicles()) {
            if(vehicle instanceof LuxuryCar &&
                    !authenticator.getLoggedUser().getRole().equals("ADMIN")) {
                continue;
            }
            System.out.println(vehicle);
        }
    }

    @Override
    public String readPlate() {
        System.out.println("Enter plate:");
        return scanner.nextLine();
    }

    @Override
    public void showResult(boolean result) {
        if(result) {
            System.out.println("Success !!");
        } else {
            System.out.println("Error !!");
        }
    }

    @Override
    public User readAuthData() {
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Password:");
        return new User(login, scanner.nextLine());
    }
}
