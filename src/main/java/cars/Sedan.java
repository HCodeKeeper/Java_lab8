package cars;

/**
 * The {@code Sedan} class represents a sedan car, which is a specific type of car.
 * It extends the {@code Car} class and inherits its attributes.
 */
public class Sedan extends Car {

    /**
     * Constructs a sedan with the specified attributes.
     *
     * @param model            the model of the sedan
     * @param fuelConsumption the fuel consumption of the sedan in liters per 100 km
     * @param speed            the speed of the sedan in km/h
     * @param price            the price of the sedan in dollars
     */
    public Sedan(String model, double fuelConsumption, double speed, double price) {
        super(model, fuelConsumption, speed, price);
    }
}
