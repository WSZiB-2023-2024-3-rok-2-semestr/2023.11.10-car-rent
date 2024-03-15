package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.Collection;

public interface IVehicleRepository {
    Collection<Vehicle> getVehicles();
    boolean rent(String plate);
    boolean returnVehicle(String plate);
}
