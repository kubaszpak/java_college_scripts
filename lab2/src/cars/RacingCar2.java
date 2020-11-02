package cars;

public class RacingCar2 extends Car{

    private ITurboCharge iTurboCharge;

    public RacingCar2() {
        super();
        this.iTurboCharge = setITurboCharge();
    }

    public RacingCar2(boolean dirty, int power, double speed, int mass) {
        super(dirty, power, speed, mass);
        this.iTurboCharge = setITurboCharge();
    }

    private ITurboCharge setITurboCharge(){
        ITurboCharge iTurboCharge = new ITurboCharge() {

            @Override
            public boolean getBoostFactor() {
                return true;
            }
        };
        return iTurboCharge;
    }
}
