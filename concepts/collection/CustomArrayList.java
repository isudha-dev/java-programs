package concepts.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList<T> {
    Object[] array;

    int size;
    int capacity;
    double loadFactor;

    public CustomArrayList() {
        this(10, 0.5);
    }

    public CustomArrayList(int capacity) {
        this(capacity, 0.5);
    }

    public CustomArrayList(int capacity, double loadFactor) {
        this.array = new Object[capacity];
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    public void add(Object element) {
        if(size >= capacity) {
            capacity = capacity + (int) (capacity * loadFactor);
            Object[] newArray = Arrays.copyOf(array, capacity);
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    public Object get(int index) {
        if(index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    public void delete(int index) {
        for (int i = index+1; i < size; i++) {
            array[i-1] = array[i];
        }
        size--;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>(5);
        ArrayList<Integer> list = new ArrayList<>(5);
        System.out.println("Size1: " + customArrayList.size()); // 0

        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(4);
        customArrayList.add(5);
        System.out.println("Size2: " + customArrayList.size()); // 5

        customArrayList.add(6);
        System.out.println("Size3: " + customArrayList.size()); // 6

        customArrayList.delete(5);
        System.out.println("Size4: " + customArrayList.size()); // 5

        customArrayList.add(7);
        customArrayList.get(5);
        System.out.println("Size5: " + customArrayList.size()); // 6

        customArrayList.add(8);
        customArrayList.add(9);
        customArrayList.add(10);
        customArrayList.add(11);
        customArrayList.add(12);
        customArrayList.add(13);
        customArrayList.add(14);
        System.out.println("Size6: " + customArrayList.size()); // 13

    }

}
