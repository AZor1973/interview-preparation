package interview.preparation.lesson_2;

import java.util.NoSuchElementException;

public interface MyList<T> {

    void add(T element);

    void set(int index, T element);

    T remove(int index);

    T get(int index);

    int size();

    default void checkForNotBoundOfIndex(int index, int size) {
        if (index >= size || index < 0) {
            throw new NoSuchElementException("Индекс запрашиваемого элемента вне диапазона коллекции");
        }
    }

    class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
