package pl.edu.wszib.car.rent.model;

public class Motorcycle extends Vehicle {
    private int wheels;

    public Motorcycle(String brand, String model, double price, int year, String plate, int wheels) {
        super(brand, model, price, year, plate);
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return super.toString() + " Wheels: " + this.wheels;
    }
}
