public class BoosterCar extends Car {
    int boostStartTime;

    public BoosterCar(int speedFirst3Minutes, int speedAfter, int boostStartTime) {
        super(speedFirst3Minutes, speedAfter);
        this.boostStartTime = boostStartTime;
    }

    @Override
    public String beep() {
        return "too too";
    }

    @Override
    public String toString() {
        return "BoosterCar{" + ", speedFirst3Minutes=" + speedFirst3Minutes + ", speedAfter=" + speedAfter + '}';
    }

    @Override
    public int countDistance(int duration) {
        if (boostStartTime < 0 || boostStartTime >= duration){
            return super.countDistance(duration);
        } else if (boostStartTime >= 3 && boostStartTime < duration - 3){
            return speedFirst3Minutes * 3 + (duration - 6) * speedAfter + speedAfter * 3 * 2;
        } else if (boostStartTime == 0){
            return speedFirst3Minutes * 3 * 2 + speedAfter * (duration - 3);
        } else if (boostStartTime == 1){
            return speedFirst3Minutes + speedFirst3Minutes * 2 * 2 + speedAfter * 2 + speedAfter * (duration - 4);
        } else if (boostStartTime == 2){
            return speedFirst3Minutes * 2 + speedFirst3Minutes * 2 + speedAfter * 2 * 2 + speedAfter * (duration - 5);
        } else if (boostStartTime == duration - 1){
            return speedFirst3Minutes * 3 + speedAfter * (duration - 4) + speedAfter * 2;
        } else if (boostStartTime == duration - 2){
            return speedFirst3Minutes * 3 + speedAfter * (duration - 5) + speedAfter * 2 * 2;
        } else if (boostStartTime == duration - 3){
            return speedFirst3Minutes * 3 + speedAfter * (duration - 6) + speedAfter * 3 * 2;
        }
        return 0;
    }

}


