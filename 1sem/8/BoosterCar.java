public class BoosterCar extends Car {
    int boostStartTime;

    public BoosterCar(double weight, double horsePower,int speedFirst3Minutes, int speedAfter, int boostStartTime) {
        super(weight,horsePower,speedFirst3Minutes, speedAfter);
        this.boostStartTime = boostStartTime;
    }

    @Override
    public String beep() {
        return "too too";
    }

    @Override
    public String toString() {
        return "BoosterCar{" + "weight=" + weight + "horsePower=" + horsePower + ", speedFirst3Minutes=" + speedFirst3Minutes + ", speedAfter=" + speedAfter + '}';
    }

    @Override
    public int countDistance(int duration) {
        int dist = 0;
        for (int i = 1; i <= duration; i++) {
            if (i <= 3){
                if (boostStartTime <= i && i <= boostStartTime + 2){
                    dist += 2 * this.speedFirst3Minutes;
                }
                else {
                    dist += this.speedFirst3Minutes;
                }
            }  else {
                if (boostStartTime <= i && boostStartTime + 2 >= i){
                    dist += 2*this.speedAfter;
                } else {
                    dist += this.speedAfter;
                }
            }
        }
        return dist;
    }

}


