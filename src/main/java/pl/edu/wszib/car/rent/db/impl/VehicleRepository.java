package pl.edu.wszib.car.rent.db.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.wszib.car.rent.authorization.Authenticator;
import pl.edu.wszib.car.rent.authorization.AuthenticatorV2;
import pl.edu.wszib.car.rent.authorization.IAuthenticator;
import pl.edu.wszib.car.rent.db.IVehicleRepository;
import pl.edu.wszib.car.rent.model.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class VehicleRepository implements IVehicleRepository {
    private final Map<String, Vehicle> vehicles = new HashMap<>();
    @Autowired
    private IAuthenticator authenticator;

    public VehicleRepository() {
        this.vehicles.put("KR11",
                new Car("BMW", "5", 500.00, 2020, "KR11"));
        this.vehicles.put("KR22",
                new Car("Audi", "A5", 550.00, 2021, "KR22"));
        this.vehicles.put("KR33",
                new Car("Toyota", "Corolla", 300.00, 2019, "KR33"));
        this.vehicles.put("KR44",
                new Car("Kia", "Ceed", 200.00, 2018, "KR44"));
        this.vehicles.put("KR55",
                new Car("Fiat", "126p", 100.00, 1990, "KR55"));
        this.vehicles.put("KR66",
                new Motorcycle("BMW", "S1000", 200.00,
                        2020, "KR66", 2));
        this.vehicles.put("KR77",
                new Motorcycle("Suzuki", "Super", 200.00,
                        2020, "KR77", 3));
        this.vehicles.put("KR88",
                new Truck("Scania", "Turbo", 700.00,
                        2010, "KR88", 4000));
        this.vehicles.put("BENTLEY",
                new LuxuryCar("Bentley", "Continental", 5000.00,
                        2021, "BENTLEY"));
        this.vehicles.put("FERRARI",
                new LuxuryCar("Ferrari", "Italia", 6000.00,
                        2022, "FERRARI"));
    }

    public Collection<Vehicle> getVehicles() {
        return this.vehicles.values();
    }

    public boolean rent(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);
        if(vehicle instanceof LuxuryCar && !authenticator.getLoggedUser().getRole().equals("ADMIN")) {
            return false;
        }
        if(vehicle != null && !vehicle.isRent()) {
            vehicle.setRent(true);
            return true;
        }
        return false;
    }

    public boolean returnVehicle(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);
        if(vehicle instanceof LuxuryCar && !authenticator.getLoggedUser().getRole().equals("ADMIN")) {
            return false;
        }
        if(vehicle != null && vehicle.isRent()) {
            vehicle.setRent(false);
            return true;
        }
        return false;
    }
}
