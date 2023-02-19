public class F1Car extends Car{
    public F1Car(double weight, double horsePower,int speedFirst3Minutes, int speedAfter){
        super(weight, horsePower,speedFirst3Minutes,speedAfter);
    }

    @Override
    public String beep(){
        return "Bonk Bonk";
    }

    @Override
    public String toString() {
        return "F1Car{" + "weight=" + weight + "horsePower=" + horsePower + ", speedFirst3Minutes=" + speedFirst3Minutes + ", speedAfter=" + speedAfter + '}';
    }
}
