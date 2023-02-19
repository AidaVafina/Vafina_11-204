public class CasualCar extends Car{
    public CasualCar(double weight, double hoursePower, int speedFirst3Minutes, int speedAfter){
        super(weight, hoursePower,speedFirst3Minutes,speedAfter);
    }

    @Override
    public String beep(){
        return "bom bom";
    }

    @Override
    public String toString() {
        return "CasualCar{" + "weight = " + weight + "horsePower = " + horsePower + ", speedFirst3Minutes=" + speedFirst3Minutes + ", speedAfter=" + speedAfter + '}';
    }
}