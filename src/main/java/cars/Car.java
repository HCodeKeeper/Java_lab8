package cars;

import customExceptions.CarException;

import java.util.Objects;

/**
 * The {@code Car} class represents a generic car with basic attributes.
 * It provides information such as model, fuel consumption, speed, and price.
 */
public class Car {
    private String model;
    private double fuelConsumption; // in liters per 100 km
    private double speed; // in km/h
    private double price; // in dollars

    /**
     * Constructs a car with the specified attributes.
     *
     * @param model            the model of the car
     * @param fuelConsumption the fuel consumption of the car in liters per 100 km
     * @param speed            the speed of the car in km/h
     * @param price            the price of the car in dollars
     */
    public Car(String model, double fuelConsumption, double speed, double price) {
        if (fuelConsumption < 0 || speed < 0 || price < 0) {
            throw new CarException("Invalid car attributes: fuelConsumption, speed, and price must be non-negative.");
        }
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.speed = speed;
        this.price = price;
    }


    /**
     * Gets the model of the car.
     *
     * @return the model of the car
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the fuel consumption of the car in liters per 100 km.
     *
     * @return the fuel consumption of the car
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Gets the speed of the car in km/h.
     *
     * @return the speed of the car
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Gets the price of the car in dollars.
     *
     * @return the price of the car
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a string representation of the car.
     *
     * @return a string representation of the car
     */
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }
    /**
     * Checks whether two cars are equal based on their model, fuel consumption, speed, and price.
     *
     * @param obj the object to compare with this car
     * @return true if the cars are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car otherCar = (Car) obj;
        return Double.compare(otherCar.fuelConsumption, fuelConsumption) == 0 &&
                Double.compare(otherCar.speed, speed) == 0 &&
                Double.compare(otherCar.price, price) == 0 &&
                model.equals(otherCar.model);
    }

    /**
     * Returns a hash code value for the car.
     *
     * @return a hash code value for the car
     */
    @Override
    public int hashCode() {
        return Objects.hash(model, fuelConsumption, speed, price);
    }
}
