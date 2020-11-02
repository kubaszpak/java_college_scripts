package cars;

public class RacingCar extends Car {

    private TurboCharger turboCharger;

    public RacingCar() {
        super();
        this.turboCharger = new TurboCharger(true);
    }

    public RacingCar(boolean dirty, int power, double speed, int mass, boolean turbo) {
        super(dirty, power, speed, mass);
        this.turboCharger = new TurboCharger(turbo);
    }

    @Override
    public void accelerate(double gazPedalPress) {
        gazPedalPress *= 2;
        if(this.turboCharger.getBoostFactor() == true){
            gazPedalPress += 0.1;
        }
        super.accelerate(gazPedalPress);
    }

    public class TurboCharger {
        private boolean boostFactor;

        public TurboCharger(boolean boostFactor) {
            this.boostFactor = boostFactor;
        }

        public boolean getBoostFactor() {
            return boostFactor;
        }
    }
}
