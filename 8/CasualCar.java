public class CasualCar extends Car{
    public CasualCar(int speedFirst3Minutes, int speedAfter){
        super(speedFirst3Minutes,speedAfter);
    }

    @Override
    public String beep(){
        return "bom bom";
    }

    @Override
    public String toString() {
        return "CasualCar{" +  ", speedFirst3Minutes=" + speedFirst3Minutes + ", speedAfter=" + speedAfter + '}';
    }
}