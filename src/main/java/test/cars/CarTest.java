package test.cars;
import cars.Car;
import customExceptions.CarException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testCarConstructorWithValidAttributes() {
        Car car = new Car("Model", 10.0, 100.0, 20000.0);
        assertEquals("Model", car.getModel());
        assertEquals(10.0, car.getFuelConsumption(), 0.001);
        assertEquals(100.0, car.getSpeed(), 0.001);
        assertEquals(20000.0, car.getPrice(), 0.001);
    }

    @Test
    void testCarConstructorWithInvalidFuelConsumption() {
        assertThrows(CarException.class, () -> new Car("Model", -10.0, 100.0, 20000.0));
    }

    @Test
    void testCarConstructorWithInvalidSpeed() {
        assertThrows(CarException.class, () -> new Car("Model", 10.0, -100.0, 20000.0));
    }

    @Test
    void testCarConstructorWithInvalidPrice() {
        assertThrows(CarException.class, () -> new Car("Model", 10.0, 100.0, -20000.0));
    }

    @Test
    void testGetModel() {
        Car car = new Car("Model", 10.0, 100.0, 20000.0);
        assertEquals("Model", car.getModel());
    }

    @Test
    void testGetFuelConsumption() {
        Car car = new Car("Model", 10.0, 100.0, 20000.0);
        assertEquals(10.0, car.getFuelConsumption(), 0.001);
    }

    @Test
    void testGetSpeed() {
        Car car = new Car("Model", 10.0, 100.0, 20000.0);
        assertEquals(100.0, car.getSpeed(), 0.001);
    }

    @Test
    void testGetPrice() {
        Car car = new Car("Model", 10.0, 100.0, 20000.0);
        assertEquals(20000.0, car.getPrice(), 0.001);
    }

    @Test
    void testToString() {
        Car car = new Car("Model", 10.0, 100.0, 20000.0);
        assertEquals("Car{model='Model', fuelConsumption=10.0, speed=100.0, price=20000.0}", car.toString());
    }
}

