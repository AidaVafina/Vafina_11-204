public class Race {
    public static void start(Car car1, Car car2, Car car3, int time) {
        if ((car1.countDistance(time) > car2.countDistance(time)) && (car1.countDistance(time) > car3.countDistance(time))){
            System.out.println(car1.beep());
        } else if ((car2.countDistance(time) > car1.countDistance(time)) && (car2.countDistance(time) > car3.countDistance(time))){
            System.out.println(car2.beep());
        } else if ((car3.countDistance(time) > car2.countDistance(time)) && (car3.countDistance(time)> car1.countDistance(time))){
            System.out.println(car3.beep());
        }
    }
}