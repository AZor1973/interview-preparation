package interview.preparation.lesson_1.exercise_3;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(3);
        Shape square = new Square(4);
        Shape triangle = new Triangle(3, 2, 1);

        System.out.println(circle.calculatingTheArea());
        System.out.println(square.calculatingTheArea());
        System.out.println(triangle.calculatingTheArea());
    }
}
