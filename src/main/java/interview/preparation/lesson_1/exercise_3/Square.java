package interview.preparation.lesson_1.exercise_3;

public class Square implements Shape{
    private final int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double calculatingTheArea() {
        return Math.pow(side, 2);
    }
}
