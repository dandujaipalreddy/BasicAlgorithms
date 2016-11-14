package basic.ds.ll;

import java.util.Arrays;

public class MyArrayList<T> implements IMyList<T> {

    private int size = 0;
    private T[] array;

    public MyArrayList() {
        // TODO Auto-generated constructor stub
        this(10);

    }

    public MyArrayList(int initialCapacity) {

        if (initialCapacity <= 0)
            throw new IllegalArgumentException("Initial Capacity must be greater than 0");
        array = (T[]) new Object[initialCapacity];
    }

    private void resize(int capacity) {

        if (size >= array.length) {
            int newCapacity = size + size << 1;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    @Override
    public boolean add(T element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(T element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contains(T element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

}
