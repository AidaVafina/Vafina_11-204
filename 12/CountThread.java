import java.util.ArrayList;
import java.util.List;

public class CountThread extends Thread {
    private List<Integer> integers;
    private int sum;

    public CountThread(List<Integer> integers) {
        this.integers = integers;
        this.sum = 0;
    }

    public int getSum() {
        return sum;
    }

    public void run() {
        for (int i = 0; i < integers.size(); i++) {
            sum += integers.get(i);
        }
    }
}