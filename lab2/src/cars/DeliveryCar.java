package cars;

public class DeliveryCar extends Car{
    private static int capacity = 100;
    private int load;

    public DeliveryCar() {
        this.load = 100;
    }

    public DeliveryCar(boolean dirty, int power, double speed, int mass, int load) {
        super(dirty, power, speed, mass);
        this.load = load;
    }

    public void accelerate(double gazPedalPress){
        //TODO: test load values
        gazPedalPress /= (load/10.0);
        super.accelerate(gazPedalPress);
    }

    @Override
    public String toString() {
        return "DeliveryCar{" +
                "load=" + load +
                ", speed=" + speed +
                ", dirty=" + dirty +
                ", mass=" + mass +
                '}';
    }
}
