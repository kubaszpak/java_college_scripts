package cars;

public class Car extends Vehicle{

    private int power;
    protected double speed;
    public boolean dirty;
    private static int maxSpeed = 120;
    final protected int mass;

    public Car() {
        this.power = 100;
        this.speed = 100;
        this.dirty = false;
        this.mass = 1000;
    }

    public Car(boolean dirty, int power, double speed, int mass) {
        this.dirty = dirty;
        this.power = power;
        this.speed = speed;
        this.mass = mass;
    }

    public Car(Car car)
    {
        this.power = car.power;
        this.speed = car.speed;
        this.dirty = car.dirty;
        this.mass = car.mass;

    }

    public int getMass() {
        return mass;
    }

    //TODO: should the constructor be final or the var
//    public final void setMass(int mass) {
//        this.mass = mass;
//    }

    public void accelerate(double gazPedalPress){
        // TODO: check if gazPedalPress is between 0 and 1
        this.speed += gazPedalPress * this.mass * this.speed / 1000;

    }

    public static void limitSpeed(int newMaxSpeed){
        //TODO: how should limitSpeed affect other cars speed if its static, an array of cars? if?
            maxSpeed = newMaxSpeed;
    }

    public void dirty() {
        this.dirty = false;
    }

    public void clean() {
        this.dirty = true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
                ", speed=" + speed +
                ", dirty=" + dirty +
                ", mass=" + mass +
                '}';
    }
}
