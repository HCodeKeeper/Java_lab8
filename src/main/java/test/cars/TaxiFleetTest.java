package test.cars;

import cars.Car;
import customExceptions.CarException;
import fleet.TaxiFleet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxiFleetTest {

    @Test
    void testTaxiFleetConstructorWithValidCars() {
        Car[] cars = {
                new Car("Model1", 10.0, 100.0, 20000.0),
                new Car("Model2", 12.0, 120.0, 25000.0)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);
        assertArrayEquals(cars, taxiFleet.getCars());
    }

    @Test
    void testTaxiFleetConstructorWithNullCars() {
        assertThrows(CarException.class, () -> new TaxiFleet(null));
    }

    @Test
    void testTaxiFleetConstructorWithEmptyCars() {
        Car[] cars = {};
        assertThrows(CarException.class, () -> new TaxiFleet(cars));
    }

    @Test
    void testCalculateFleetCost() {
        Car[] cars = {
                new Car("Model1", 10.0, 100.0, 20000.0),
                new Car("Model2", 12.0, 120.0, 25000.0)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);
        assertEquals(45000.0, taxiFleet.calculateFleetCost(), 0.001);
    }

    @Test
    void testSortByFuelConsumption() {
        Car[] cars = {
                new Car("Model1", 12.0, 100.0, 20000.0),
                new Car("Model2", 10.0, 120.0, 25000.0)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);
        taxiFleet.sortByFuelConsumption();
        assertEquals(10.0, taxiFleet.getCars()[0].getFuelConsumption(), 0.001);
        assertEquals(12.0, taxiFleet.getCars()[1].getFuelConsumption(), 0.001);
    }

    @Test
    void testFindCarBySpeedRange() {
        Car[] cars = {
                new Car("Model1", 10.0, 100.0, 20000.0),
                new Car("Model2", 12.0, 120.0, 25000.0)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);
        Car foundCar = taxiFleet.findCarBySpeedRange(110.0, 130.0);
        assertNotNull(foundCar);
        assertEquals("Model2", foundCar.getModel());
    }

    @Test
    void testFindCarBySpeedRangeWhenNoCarFound() {
        Car[] cars = {
                new Car("Model1", 10.0, 100.0, 20000.0),
                new Car("Model2", 12.0, 120.0, 25000.0)
        };
        TaxiFleet taxiFleet = new TaxiFleet(cars);
        Car foundCar = taxiFleet.findCarBySpeedRange(130.0, 140.0);
        assertNull(foundCar);
    }
}
