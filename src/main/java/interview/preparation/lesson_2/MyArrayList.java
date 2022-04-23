package interview.preparation.lesson_2;

public class MyArrayList<T> implements MyList<T> {
    private static final Integer initialCapacity = 10;
    private Object[] array;
    private int size;
    private int capacity;

    public MyArrayList() {
        array = new Object[initialCapacity];
        capacity = initialCapacity;
    }

    @Override
    public void add(T element) {
        if (size == capacity) {
            capacity = (int) (size * 1.5);
            Object[] result = new Object[capacity];
            System.arraycopy(array, 0, result, 0, size);
            array = result;
        }
        for (int i = 0; i < capacity; i++) {
            if (array[i] == null) {
                array[i] = element;
                size++;
                return;
            }
        }
    }

    @Override
    public void set(int index, T element) {
        checkForNotBoundOfIndex(index, size);
        array[index] = element;
    }

    @Override
    public T remove(int index) {
        T removed = get(index);
        checkForNotBoundOfIndex(index, size);
        Object[] result = new Object[size];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(array, index + 1, result, index, size - index - 1);
        array = result;
        size--;
        return removed;
    }

    @Override
    public T get(int index) {
        checkForNotBoundOfIndex(index, size);
        return (T) array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("MyArrayList {");
        for (int i = 0; i < size; i++) {
            stb.append(array[i]);
            if (i != size - 1) {
                stb.append(", ");
            }
        }
        stb.append("}");
        return stb.toString();
    }
}
