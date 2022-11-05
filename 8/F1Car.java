public class F1Car extends Car{
    public F1Car(int speedFirst3Minutes, int speedAfter){
        super(speedFirst3Minutes,speedAfter);
    }

    @Override
    public String beep(){
        return "Bonk Bonk";
    }

    @Override
    public String toString() {
        return "F1Car{" + "weight=" + ", speedFirst3Minutes=" + speedFirst3Minutes + ", speedAfter=" + speedAfter + '}';
    }
}
