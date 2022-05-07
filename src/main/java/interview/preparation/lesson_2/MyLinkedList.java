package interview.preparation.lesson_2;

public class MyLinkedList<T> implements MyList<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    @Override
    public void add(T element) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(element, null, l);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T element) {
        checkForNotBoundOfIndex(index, size);
        if (index < size / 2) {
            int currentIndex = -1;
            Node<T> currentNode = first;
            while (currentNode != null) {
                currentIndex++;
                if (currentIndex == index) {
                    currentNode.item = element;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
        int currentIndex = size;
        Node<T> currentNode = last;
        while (currentNode != null) {
            currentIndex--;
            if (currentIndex == index) {
                currentNode.item = element;
                break;
            }
            currentNode = currentNode.prev;
        }
    }

    @Override
    public T remove(int index) {
        checkForNotBoundOfIndex(index, size);
        if (index < size / 2) {
            int currentIndex = -1;
            Node<T> currentNode = first;
            while (currentNode != null) {
                currentIndex++;
                if (remove(index, currentIndex, currentNode)) return currentNode.item;
                currentNode = currentNode.next;
            }
        }
        int currentIndex = size;
        Node<T> currentNode = last;
        while (currentNode != null) {
            currentIndex--;
            if (remove(index, currentIndex, currentNode)) return currentNode.item;
            currentNode = currentNode.prev;
        }
        return null;
    }

    private boolean remove(int index, int currentIndex, Node<T> currentNode) {
        if (currentIndex == index) {
            if (currentNode.prev != null) {
                currentNode.prev.next = currentNode.next;
            } else {
                first = currentNode.next;
            }
            if (currentNode.next != null) {
                currentNode.next.prev = currentNode.prev;
            } else {
                last = currentNode.prev;
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public T get(int index) {
        checkForNotBoundOfIndex(index, size);
        if (index < size / 2) {
            int currentIndex = -1;
            Node<T> currentNode = first;
            while (currentNode != null) {
                currentIndex++;
                if (currentIndex == index) {
                    return currentNode.item;
                }
                currentNode = currentNode.next;
            }
        }
        int currentIndex = size;
        Node<T> currentNode = last;
        while (currentNode != null) {
            currentIndex--;
            if (currentIndex == index) {
                return currentNode.item;
            }
            currentNode = currentNode.prev;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("{");
        Node<T> currentNode = first;
        while (currentNode != null && currentNode.item != null) {
            stb.append(currentNode.item);
            if (currentNode.next != null) {
                stb.append(", ");
            }
            currentNode = currentNode.next;
        }
        stb.append("}");
        return stb.toString();
    }
}
