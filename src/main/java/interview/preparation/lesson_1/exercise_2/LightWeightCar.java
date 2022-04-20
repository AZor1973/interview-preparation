package interview.preparation.lesson_1.exercise_2;

//class LightWeightCar extends Car implements Moveable {
//    @Override
//    void open() {
//        System.out.println("Car is open");
//    }
//    @Override
//    public void move() {
//        System.out.println("Car is moving");
//    }
//}
class LightWeightCar extends Car {
    @Override
    public void open() {
        System.out.println("LightWeightCar is open");
    }

    @Override
    public void move() {
        System.out.println("LightWeightCar is move");
    }
}