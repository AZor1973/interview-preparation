package interview.preparation.lesson_1.exercise_3;

public class Circle implements Shape{
    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double calculatingTheArea() {
        return Math.PI*Math.pow(radius, 2);
    }

    public double calculatingTheArea(double pi){
        return pi*Math.pow(radius, 2);
    }
}
