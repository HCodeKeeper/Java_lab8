package fleet;

import cars.Car;

import java.util.*;

/**
 * A custom implementation of the Set interface using an array as the internal storage.
 * The set dynamically adjusts its capacity based on the number of elements it contains.
 *
 */
public class CarsSet implements Set<Car> {
    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    private Car[] array;
    private int size;

    /**
     * Constructs an empty fleet.CarsSet with the initial capacity.
     */
    public CarsSet() {
        this.array = new Car[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Constructs a fleet.CarsSet that is a copy of another fleet.CarsSet.
     *
     * @param otherSet the fleet.CarsSet to copy
     */
    public CarsSet(CarsSet otherSet) {
        this.array = Arrays.copyOf(otherSet.array, otherSet.size);
        this.size = otherSet.size;
    }

    /**
     * Constructs a fleet.CarsSet containing elements of the specified collection.
     *
     * @param collection the collection whose elements are to be placed into this set
     */
    public CarsSet(Collection<? extends Car> collection) {
        this.array = new Car[INITIAL_CAPACITY];
        this.addAll(collection);
    }

    /**
     * Increases the capacity of the array if the specified minimum capacity is greater than the current capacity.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = (int) (array.length * GROWTH_FACTOR);
            array = Arrays.copyOf(array, Math.max(newCapacity, minCapacity));
        }
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements in this set
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this set contains no elements.
     *
     * @return true if this set contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this set contains the specified element.
     *
     * @param o the element to check for containment
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, array[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this set.
     *
     * @return an iterator over the elements in this set
     */
    @Override
    public Iterator<Car> iterator() {
        return new CarsSetIterator();
    }

    /**
     * An iterator for the fleet.CarsSet.
     */
    private class CarsSetIterator implements Iterator<Car> {
        private int index = 0;

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Car next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (Car) array[index++];
        }
    }

    /**
     * Returns an array containing all the elements in this set.
     *
     * @return an array containing all the elements in this set
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    /**
     * Increases the capacity of the array if necessary and specified minimum capacity is greater than the current capacity.
     */
    // Перевірка та збільшення масиву при необхідності
    private void ensureCapacity() {
        if (size == array.length) {
            int newSize = Math.max(INITIAL_CAPACITY, (int) (array.length * GROWTH_FACTOR));
            array = Arrays.copyOf(array, newSize);
        }
    }

    /**
     * Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of this set are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose
     * @param <T> the runtime type of the array to contain the collection
     * @return an array containing all of the elements in this set
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        }
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Adds the specified element to this set if it is not already present.
     *
     * @param e the element to be added to this set
     * @return true if this set did not already contain the specified element
     */
    @Override
    public boolean add(Car e) {
        if (contains(e)) {
            return false; // Вже міститься, не додаємо знову
        }

        ensureCapacity(); // Перевірка і збільшення масиву при необхідності
        array[size++] = e;
        return true;
    }

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param o the object to be removed from this set
     * @return true if this set contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, array[i])) {
                removeAtIndex(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the element at the specified index and adjusts the array accordingly.
     *
     * @param index the index of the element to be removed
     */
    private void removeAtIndex(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null; // Зменшуємо розмір і очищуємо останній елемент
    }

    /**
     * Checks if this set contains all elements in the specified collection.
     *
     * @param c the collection to be checked for containment
     * @return true if this set contains all elements in the specified collection
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all elements in the specified collection to this set.
     *
     * @param c the collection containing elements to be added to this set
     * @return true if this set is modified as a result of the operation
     */
    @Override
    public boolean addAll(Collection<? extends Car> c) {
        boolean modified = false;
        for (Car element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this set that are contained in the specified collection.
     *
     * @param c the collection containing elements to be retained in this set
     * @return true if this set is modified as a result of the operation
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, true);
    }

    /**
     * Removes from this set all elements contained in the specified collection.
     *
     * @param c the collection containing elements to be removed from this set
     * @return true if this set is modified as a result of the operation
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, false);
    }

    /**
     * Removes elements from this set based on the specified condition.
     *
     * @param c          the collection of elements to be checked for removal
     * @param complement if true, removes elements not present in the specified collection
     * @return true if this set is modified as a result of the operation
     */
    private boolean batchRemove(Collection<?> c, boolean complement) {
        final Object[] elementData = array;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++) {
                if (c.contains(elementData[r]) == complement) {
                    elementData[w++] = elementData[r];
                    modified = true; // Set modified to true when an element is removed
                }
            }
        } finally {
            // Clearing memory from "extra" elements that were replaced
            for (int i = w; i < size; i++) {
                elementData[i] = null;
            }
            size = w;
        }
        return modified;
    }


    /**
     * Removes all elements from this set.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
}
