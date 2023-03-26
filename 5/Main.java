import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("honda.csv"));
        List<Car> carList = new ArrayList<>();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String s1 = scanner.nextLine();
            String[] strings = s1.split(",");
            if (s1.isEmpty()) {
                continue;
            }
            carList.add(new Car(Integer.parseInt(strings[0]), Integer.parseInt(strings[1].split(" ")[0]), strings[2], strings[3], Double.parseDouble(strings[4].split(" ")[0]), strings[5]));
        }

        List<Car> carListPetrolAutomatic = carList.stream().filter(x -> x.fuelType.equals("Petrol")).filter(x -> x.suspension.equals("Automatic")).collect(Collectors.toList());
        System.out.println(carListPetrolAutomatic);

        long priceCar = carList.stream().map(Car::getPrice).mapToInt(Double::intValue).filter(x -> x % 2 == 0).count();
        System.out.println(priceCar);

        Double average = carList.stream().collect(Collectors.averagingDouble(Car::getPrice));
        long count2 = carList.stream().filter(x -> x.getPrice() > average).count();
        System.out.println(count2);

        List<Car> kmsDriven = carList.stream().filter(x -> x.kmsDriven < 10000).collect(Collectors.toList());
        System.out.println(kmsDriven);

        long carHondaCityCar = carList.stream().filter(x -> x.carModel.split(" ")[0].equals("Honda")).filter(x -> x.carModel.split(" ")[1].equals("City")).filter(x -> x.getYear() >= 2015).count();
        System.out.println(carHondaCityCar);
    }

    public static class Car{
        int year;
        Integer kmsDriven;
        String fuelType;
        String suspension;
        Double price;
        String carModel;

        public Car(int year, int kmsDriven, String fuelType, String suspension, Double price, String carModel){
            this.year = year;
            this.kmsDriven = kmsDriven;
            this.fuelType = fuelType;
            this.suspension = suspension;
            this.price = price;
            this.carModel = carModel;
        }

        public Double getPrice() {
            return price;
        }

        public int getKmsDriven(){
            return kmsDriven;
        }

        public int getYear(){
            return year;
        }

        @Override
        public String toString(){
            return "Car {" + "year: " + year + ", kmsDriven: " + kmsDriven + ", fuelType: " + fuelType + ", suspension: " + suspension + ", price" + price + ", csrModel: " + carModel;
        }
    }
}
