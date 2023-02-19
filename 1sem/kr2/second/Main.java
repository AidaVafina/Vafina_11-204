package second;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int cnt = 0;
        int chk = 0;
        Random random = new Random();
        while (chk < 10){
            int num = random.nextInt();
            if (Integer.toString(num).matches("([^02468]*)([02468]{0,2})([^02468]*)")){
                System.out.println(num);
                chk += 1;
            }
            cnt += 1;
        }
        System.out.println(cnt);
    }
}
