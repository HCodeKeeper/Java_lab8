package cars;

/**
 * The {@code SUV} class represents a sports utility vehicle (SUV), which is a specific type of car.
 * It extends the {@code Car} class and inherits its attributes.
 */
public class SUV extends Car {

    /**
     * Constructs an SUV with the specified attributes.
     *
     * @param model            the model of the SUV
     * @param fuelConsumption the fuel consumption of the SUV in liters per 100 km
     * @param speed            the speed of the SUV in km/h
     * @param price            the price of the SUV in dollars
     */
    public SUV(String model, double fuelConsumption, double speed, double price) {
        super(model, fuelConsumption, speed, price);
    }
}
