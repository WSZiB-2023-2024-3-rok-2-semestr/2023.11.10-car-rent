package pl.edu.wszib.car.rent.model;

public class Vehicle {
    private String brand;
    private String model;
    private double price;
    private int year;
    private String plate;
    private boolean rent;

    public Vehicle(String brand, String model, double price, int year, String plate) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.year = year;
        this.plate = plate;
        this.rent = false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getBrand())
                .append(" ")
                .append(this.getModel())
                .append(" Price: ")
                .append(this.getPrice())
                .append(" Year: ")
                .append(this.getYear())
                .append(" Plate: ")
                .append(this.getPlate())
                .append(this.isRent() ? " Not available" : " Available")
                .toString();
    }
}
