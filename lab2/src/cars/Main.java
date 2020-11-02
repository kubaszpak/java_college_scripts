package cars;

public class Main {

    public static void main(String[] args){
        Car car = new Car();
        System.out.println(car.toString());
        car.accelerate(0.5);
        System.out.println(car.toString());

        Car deliveryCar = new DeliveryCar();
        System.out.println(deliveryCar.toString());
        deliveryCar.accelerate(0.5);
        System.out.println(deliveryCar.toString());

        Car racingCar = new RacingCar();
        System.out.println(racingCar);
        racingCar.accelerate(0.5);
        System.out.println(racingCar.toString());
    }

}
