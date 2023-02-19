public class MainCar {
    public static void main(String[] args) {
        CasualCar casualCar = new CasualCar(200, 300, 60, 120);
        F1Car f1Car = new F1Car(200, 200, 40, 240);
        BoosterCar boosterCar = new BoosterCar(200,250,40,100,1);

        System.out.println(casualCar.countDistance(3));
        System.out.println(boosterCar.countDistance(3));
        System.out.println(f1Car.countDistance(3));

        Race.start(casualCar,boosterCar,f1Car,3);
    }
}
