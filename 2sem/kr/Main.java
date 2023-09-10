import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public class MyStack<T> extends AbstractCollection<T>{
        List list = new ArrayList();

        public T push(T item) {
            list.add(item);

            return item;
        }

        public boolean empty() {
            return list.isEmpty();
        }

        public int search(T item) {
            int pos = list.indexOf(item);
            if (pos == -1) {
                return -1;
            }
            return size() - 1;
        }

        public T peek() {
            if (list.isEmpty()) {
                throw new NoSuchElementException();
            }
            return (T) list.get(list.size()-1);
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("honda (2).csv"));
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
        //System.out.println(carList);

        // 3 задание
        List<Car> sortedCars = (List<Car>) carList.stream().sorted((x, y) -> x.kmsDriven.compareTo(y.kmsDriven)).collect(Collectors.toList());
        //System.out.println(sortedCars);

        // 5 задание
        List<Car> sortedCars2 = (List<Car>) carList.stream().sorted((x, y) -> x.price.compareTo(y.price)).collect(Collectors.toList());
        System.out.println(sortedCars2.get(0));

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

        @Override
        public String toString(){
            return "Car {" + "year: " + year + ", kmsDriven: " + kmsDriven + ", fuelType: " + fuelType + ", suspension: " + suspension + ", price" + price + ", csrModel: " + carModel;
        }

    }
}

