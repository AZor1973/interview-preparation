package interview.preparation.lesson_1.exercise_3;

public class Triangle implements Shape{
    private final double firstSide;
    private final double secondSide;
    private final double angle;

    public Triangle(double firstSide, double secondSide, double angle) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.angle = angle;
    }

    @Override
    public double calculatingTheArea() {
        return (firstSide*secondSide/2)*Math.sin(angle);
    }
}
