public class Car {
    double weight;
    double horsePower;
    public int speedFirst3Minutes;
    public int speedAfter;

    public Car(double weight, double horsePower, int speedFirst3Minutes, int speedAfter) {
        this.weight = weight;
        this.horsePower = horsePower;
        this.speedFirst3Minutes = speedFirst3Minutes;
        this.speedAfter = speedAfter;
    }

    public Car(){
    }

    public String beep(){
        return "beep beep";
    }

    public int countDistance(int duration){
        return speedFirst3Minutes * 3 + speedAfter * (duration - 3);
    }
}