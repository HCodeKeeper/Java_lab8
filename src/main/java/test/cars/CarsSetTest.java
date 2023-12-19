package test.cars;

import cars.Car;
import fleet.CarsSet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CarsSetTest {

    @Test
    void testEmptyConstructor() {
        CarsSet carsSet = new CarsSet();
        assertEquals(0, carsSet.size());
        assertTrue(carsSet.isEmpty());
    }

    @Test
    void testCopyConstructor() {
        CarsSet originalSet = new CarsSet();
        originalSet.add(new Car("Model1", 10.0, 100.0, 20000.0));
        CarsSet copiedSet = new CarsSet(originalSet);

        assertEquals(originalSet.size(), copiedSet.size());
        assertTrue(copiedSet.containsAll(originalSet));
    }

    @Test
    void testCollectionConstructor() {
        Collection<Car> carCollection = Arrays.asList(
                new Car("Model1", 10.0, 100.0, 20000.0),
                new Car("Model2", 12.0, 120.0, 25000.0)
        );
        CarsSet carsSet = new CarsSet(carCollection);

        assertEquals(carCollection.size(), carsSet.size());
        assertTrue(carsSet.containsAll(carCollection));
    }

    @Test
    void testSizeAndIsEmpty() {
        CarsSet carsSet = new CarsSet();
        assertTrue(carsSet.isEmpty());

        carsSet.add(new Car("Model1", 10.0, 100.0, 20000.0));
        assertFalse(carsSet.isEmpty());

        carsSet.remove(new Car("Model1", 10.0, 100.0, 20000.0));
        assertTrue(carsSet.isEmpty());
    }

    @Test
    void testContains() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);

        assertFalse(carsSet.contains(car1));
        assertFalse(carsSet.contains(car2));

        carsSet.add(car1);
        assertTrue(carsSet.contains(car1));
        assertFalse(carsSet.contains(car2));

        carsSet.add(car2);
        assertTrue(carsSet.contains(car1));
        assertTrue(carsSet.contains(car2));
    }

    @Test
    void testIterator() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);

        carsSet.add(car1);
        carsSet.add(car2);

        Iterator<Car> iterator = carsSet.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(car1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(car2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testToArray() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);

        carsSet.add(car1);
        carsSet.add(car2);

        Object[] array = carsSet.toArray();
        assertEquals(2, array.length);
        assertTrue(Arrays.asList(array).contains(car1));
        assertTrue(Arrays.asList(array).contains(car2));
    }

    @Test
    void testToArrayWithType() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);

        carsSet.add(car1);
        carsSet.add(car2);

        Car[] carArray = carsSet.toArray(new Car[0]);
        assertEquals(2, carArray.length);
        assertTrue(Arrays.asList(carArray).contains(car1));
        assertTrue(Arrays.asList(carArray).contains(car2));
    }

    @Test
    void testAdd() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);

        assertTrue(carsSet.add(car1));
        assertEquals(1, carsSet.size());
        assertTrue(carsSet.contains(car1));

        // Adding the same element again should return false
        assertFalse(carsSet.add(car1));
        assertEquals(1, carsSet.size());

        assertTrue(carsSet.add(car2));
        assertEquals(2, carsSet.size());
        assertTrue(carsSet.contains(car2));
    }

    @Test
    void testRemove() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);

        assertFalse(carsSet.remove(car1)); // Removing from an empty set should return false

        carsSet.add(car1);
        assertTrue(carsSet.remove(car1));
        assertEquals(0, carsSet.size());
        assertFalse(carsSet.contains(car1));

        carsSet.add(car2);
        assertFalse(carsSet.remove(car1)); // Removing a non-existent element should return false
        assertEquals(1, carsSet.size());
        assertTrue(carsSet.contains(car2));

        assertTrue(carsSet.remove(car2));
        assertEquals(0, carsSet.size());
        assertFalse(carsSet.contains(car2));
    }

    @Test
    void testContainsAll() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);
        carsSet.add(car1);
        carsSet.add(car2);

        assertTrue(carsSet.containsAll(Arrays.asList(car1, car2)));
        assertFalse(carsSet.containsAll(Arrays.asList(car1, new Car("Model3", 15.0, 150.0, 30000.0))));
    }

    @Test
    void testAddAll() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);

        assertTrue(carsSet.addAll(Arrays.asList(car1, car2)));
        assertEquals(2, carsSet.size());
        assertTrue(carsSet.contains(car1));
        assertTrue(carsSet.contains(car2));

        // Adding the same elements again should return false
        assertFalse(carsSet.addAll(Arrays.asList(car1, car2)));
        assertEquals(2, carsSet.size());
    }

    @Test
    void testClear() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);

        carsSet.addAll(Arrays.asList(car1, car2));

        carsSet.clear();
        assertEquals(0, carsSet.size());
        assertTrue(carsSet.isEmpty());
    }

    @Test
    void testRetainAll() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);
        Car car3 = new Car("Model3", 15.0, 150.0, 30000.0);

        carsSet.addAll(Arrays.asList(car1, car2, car3));

        // Retaining car1 and car2, removing car3
        assertTrue(carsSet.retainAll(Arrays.asList(car1, car2)));
        assertEquals(2, carsSet.size());
        assertTrue(carsSet.contains(car1));
        assertTrue(carsSet.contains(car2));
        assertFalse(carsSet.contains(car3));
    }

    @Test
    void testRemoveAll() {
        CarsSet carsSet = new CarsSet();
        Car car1 = new Car("Model1", 10.0, 100.0, 20000.0);
        Car car2 = new Car("Model2", 12.0, 120.0, 25000.0);
        Car car3 = new Car("Model3", 15.0, 150.0, 30000.0);

        carsSet.addAll(Arrays.asList(car1, car2, car3));

        // Removing car1 and car2, retaining car3
        assertTrue(carsSet.removeAll(Arrays.asList(car1, car2)));
        assertEquals(1, carsSet.size());
        assertFalse(carsSet.contains(car1));
        assertFalse(carsSet.contains(car2));
        assertTrue(carsSet.contains(car3));
    }
}


