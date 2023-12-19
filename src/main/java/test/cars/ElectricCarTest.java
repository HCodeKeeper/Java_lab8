package test.cars;
import cars.ElectricCar;
import customExceptions.CarException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElectricCarTest {

    @Test
    void testElectricCarConstructorWithValidAttributes() {
        ElectricCar electricCar = new ElectricCar("Model", 50.0, 120.0, 50000.0);
        assertEquals("Model", electricCar.getModel());
        assertEquals(0, electricCar.getFuelConsumption(), 0.001); // Fuel consumption is set to 0
        assertEquals(120.0, electricCar.getSpeed(), 0.001);
        assertEquals(50000.0, electricCar.getPrice(), 0.001);
        assertEquals(50.0, electricCar.getWatt(), 0.001);
    }

    @Test
    void testElectricCarConstructorWithInvalidWatt() {
        assertThrows(CarException.class, () -> new ElectricCar("Model", -50.0, 120.0, 50000.0));
    }

    @Test
    void testElectricCarGetWatt() {
        ElectricCar electricCar = new ElectricCar("Model", 50.0, 120.0, 50000.0);
        assertEquals(50.0, electricCar.getWatt(), 0.001);
    }

    @Test
    void testElectricCarToString() {
        ElectricCar electricCar = new ElectricCar("Model", 50.0, 120.0, 50000.0);
        assertEquals("Car{model='Model', fuelConsumption=0.0, speed=120.0, price=50000.0}", electricCar.toString());
    }
}
