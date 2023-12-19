package fleet;

import cars.Car;
import customExceptions.CarException;

import java.util.Arrays;

/**
 * The {@code fleet.TaxiFleet} class represents a fleet of taxi cars. It contains methods for calculating the total cost
 * of the fleet, sorting the cars by fuel consumption, and finding a car within a specified speed range.
 */
public class TaxiFleet {

    /**
     * An array of cars in the taxi fleet.
     */
    private Car[] cars;

    /**
     * Constructs a taxi fleet with the specified array of cars.
     *
     * @param cars an array of cars in the taxi fleet
     */
    public TaxiFleet(Car[] cars) {
        if (cars == null || cars.length == 0) {
            throw new CarException("Invalid taxi fleet: must contain at least one car.");
        }
        this.cars = cars;
    }

    /**
     * Retrieves copy of cars array
     * @return copy of Cars array
     */
    public Car[] getCars() {
        return cars.clone();
    }

    /**
     * Calculates the total cost of the taxi fleet.
     *
     * @return the total cost of the taxi fleet in dollars
     */
    public double calculateFleetCost() {
        return Arrays.stream(cars).mapToDouble(Car::getPrice).sum();
    }

    /**
     * Sorts the cars in the taxi fleet by fuel consumption in ascending order.
     */
    public void sortByFuelConsumption() {
        Arrays.sort(cars, (car1, car2) -> Double.compare(car1.getFuelConsumption(), car2.getFuelConsumption()));
    }

    /**
     * Finds a car within the specified speed range.
     *
     * @param minSpeed the minimum speed of the desired car
     * @param maxSpeed the maximum speed of the desired car
     * @return a car within the specified speed range, or {@code null} if no such car is found
     */
    public Car findCarBySpeedRange(double minSpeed, double maxSpeed) {
        return Arrays.stream(cars)
                .filter(car -> car.getSpeed() >= minSpeed && car.getSpeed() <= maxSpeed)
                .findFirst()
                .orElse(null);
    }
}
