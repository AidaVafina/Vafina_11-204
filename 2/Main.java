import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ranking.csv"));
        List<Ranking> rankingList = new ArrayList<>();
        scanner.nextLine();
        while (scanner.hasNextLine()){
            String s1 = scanner.nextLine();
            String[] strings = s1.split(",");
            if (s1.isEmpty()){
                continue;
            }
            rankingList.add(new Ranking(strings[0], strings[1], strings[4], Integer.parseInt(strings[5]), Integer.parseInt(strings[3])));
        }

        Scanner scanner1 = new Scanner(new File("ranking.csv"));
        List<ExtendedRanking> extendedRankings = new ArrayList<>();
        scanner1.nextLine();
        while (scanner1.hasNextLine()){
            String s2 = scanner1.nextLine();
            String[] strings1 = s2.split(",");
            if (s2.isEmpty()){
                continue;
            }
            extendedRankings.add(new ExtendedRanking(strings1[0], strings1[1], strings1[4], Integer.parseInt(strings1[5]), Integer.parseInt(strings1[3]), (char) 68, Integer.parseInt(strings1[9]), Integer.parseInt(strings1[8])));
        }
        //System.out.println(extendedRankings);

        Comparator<Ranking> comparator = (x,y) -> x.prRating.compareTo(y.prRating);
        Comparator<ExtendedRanking> comparator1 = (x,y) -> x.led.compareTo(y.led);
        Comparator<Ranking> comparator2 = (x,y) -> x.country.compareTo(y.country);
    }




    static class Ranking{
        String country;
        String region;
        String status;
        Integer prRating;
        Integer edition;

        public Ranking(String country, String region, String status, int prRating, int edition){
            this.country = country;
            this.region = region;
            this.status = status;
            this.prRating = prRating;
            this.edition = edition;
        }

        public Ranking() {
        }

        public static int sortList(Comparator<? super Ranking> comparator, List<? extends Ranking> list){
            list.sort(comparator);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).prRating == 5){
                    return i;
                }
            }
            return -1;
        }
    }

    static class ExtendedRanking extends Ranking{
        Character led;
        Integer A3;
        Integer A2;

        public ExtendedRanking(String country, String region, String status, int prRating, int edition, Character led, int A3, int A2) {
            super(country, region, status, prRating, edition);
            this.led = led;
            this.A2 = A2;
            this.A3 = A3;
        }

        public ExtendedRanking() {
            super();
        }

        public static void addEl(List<? super ExtendedRanking> list, int n){
            for (int i = 0; i < n; i++){
                list.add(new ExtendedRanking());
            }
        }
    }
}

