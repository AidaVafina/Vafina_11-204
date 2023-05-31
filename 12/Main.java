import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        PartitionService partitionService = new PartitionService(integerList, 3);
        int sum = partitionService.countArrayPartitionSum();
        System.out.println("Sum integers: " + sum);
    }
}
