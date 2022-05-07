package interview.preparation.lesson_2;

public class TestArrayList {
    public static void main(String[] args) {
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(arrayList);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11);
        System.out.println(arrayList);
        System.out.println("Get: " + arrayList.get(5));
        System.out.println("Get: " + arrayList.get(9));
        System.out.println("Removed: " + arrayList.remove(5));
        System.out.println(arrayList);
        System.out.println("Removed: " + arrayList.remove(0));
        System.out.println(arrayList);
        System.out.println("Removed: " + arrayList.remove(5));
        System.out.println(arrayList);
        arrayList.set(0, 20);
        System.out.println(arrayList);
        System.out.println("Size: " + arrayList.size());

//      NoSuchElementException
        System.out.println(arrayList.get(12));
    }
}
