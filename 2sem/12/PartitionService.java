import java.util.ArrayList;
import java.util.List;

public class PartitionService {
    private List<Integer> integerList;
    private Integer partitionSize;

    public PartitionService(List<Integer> integerList, Integer partitionSize) {
        this.integerList = integerList;
        this.partitionSize = partitionSize;
    }

    public int countArrayPartitionSum() {
        List<CountThread> threads = new ArrayList<>();
        int startIndex = 0;
        int endIndex;

        while (startIndex < integerList.size()) {
            endIndex = Math.min(startIndex + partitionSize, integerList.size());
            List<Integer> subList = integerList.subList(startIndex, endIndex);
            CountThread thread = new CountThread(subList);
            threads.add(thread);
            thread.start();
            startIndex = endIndex;
        }

        int totalSum = 0;
        for (CountThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            totalSum += thread.getSum();
        }

        return totalSum;
    }
}