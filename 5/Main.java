import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ranking.csv"));
        List<Ranking> rankingList = new ArrayList<>();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String s1 = scanner.nextLine();
            String[] strings = s1.split(",");
            if (s1.isEmpty()) {
                continue;
            }
            rankingList.add(new Ranking(strings[0], strings[1], strings[4], Integer.parseInt(strings[5]), Integer.parseInt(strings[3])));
        }
    }
}
