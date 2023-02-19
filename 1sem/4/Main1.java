import java.util.Scanner;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dlin = scanner.nextInt();
        int[] a = new int[dlin];
        int sum = 0;
        for (int i = 0; i < dlin; i++){
            a[i] = scanner.nextInt();
            sum += a[i];
        }
        System.out.println(a);
        System.out.println(sum);



}
}