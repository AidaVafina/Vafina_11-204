public class MainCar {
    public static void main(String[] args) {
        CasualCar car1 = new CasualCar(100, 150);
        F1Car car2 = new F1Car( 60, 220);
        BoosterCar car3 = new BoosterCar(100,200,8);

        System.out.println(car1.countDistance(10));
        System.out.println(car2.countDistance(10));
        System.out.println(car3.countDistance(10));

        Car firstCar = new Car(50,45);
        F1Car secondCar = new F1Car(32,12);
        BoosterCar thirdCar = new BoosterCar(40,30,1);
        Race.start(firstCar,secondCar,thirdCar,6);
    }
}
