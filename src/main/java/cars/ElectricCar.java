package cars;

import customExceptions.CarException;

/**
 * The {@code ElectricCar} class represents an electric car, which is a specific type of car that operates
 * using an electric motor. It extends the {@code Car} class and inherits some of its attributes.
 */
public class ElectricCar extends Car {

    /**
     * The electric car's power consumption measured in kilowatts per 100 km.
     */
    private double kWatt;

    /**
     * Constructs an electric car with the specified attributes.
     *
     * @param model   the model of the electric car
     * @param kWatt   the power consumption of the electric car in kilowatts per 100 km
     * @param speed   the speed of the electric car in km/h
     * @param price   the price of the electric car in dollars
     */
    public ElectricCar(String model, double kWatt, double speed, double price) {
        super(model, 0, speed, price); // Fuel consumption is set to 0 for electric cars
        if (kWatt < 0) {
            throw new CarException("Invalid electric car attribute: kWatt must be non-negative.");
        }
        this.kWatt = kWatt;
    }

    /**
     * Gets the power consumption of the electric car in kilowatts per 100 km.
     *
     * @return the power consumption in kilowatts per 100 km
     */
    public double getWatt() {
        return kWatt;
    }
}
