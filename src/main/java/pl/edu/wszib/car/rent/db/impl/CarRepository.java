package pl.edu.wszib.car.rent.db.impl;

import pl.edu.wszib.car.rent.model.Car;

public class CarRepository {
    private final Car[] cars = new Car[5];

    public CarRepository() {
        this.cars[0] = new Car("BMW", "5", 500.00, 2020, "KR11");
        this.cars[1] = new Car("Audi", "A5", 550.00, 2021, "KR22");
        this.cars[2] = new Car("Toyota", "Corolla", 300.00, 2019, "KR33");
        this.cars[3] = new Car("Kia", "Ceed", 200.00, 2018, "KR44");
        this.cars[4] = new Car("Fiat", "126p", 100.00, 1990, "KR55");
    }

    public Car[] getCars() {
        return cars;
    }

    public boolean rent(String plate) {
        for(Car car : this.cars) {
            if(car.getPlate().equals(plate) && !car.isRent()) {
                car.setRent(true);
                return true;
            }
        }
        return false;
    }
}
