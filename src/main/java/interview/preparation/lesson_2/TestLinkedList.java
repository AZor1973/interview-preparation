package interview.preparation.lesson_2;

public class TestLinkedList {
    public static void main(String[] args) {
        MyList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        System.out.println(myLinkedList);
        myLinkedList.set(3, 20);
        System.out.println(myLinkedList);
        System.out.println("Get: " + myLinkedList.get(3));
        System.out.println("Size: " + myLinkedList.size());
        System.out.println("Removed: " + myLinkedList.remove(0));
        System.out.println(myLinkedList);
        System.out.println("Size: " + myLinkedList.size());
        System.out.println("Removed: " + myLinkedList.remove(3));
        System.out.println(myLinkedList);
        System.out.println("Size: " + myLinkedList.size());
    }
}
