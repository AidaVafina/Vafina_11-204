import java.util.Scanner;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] s1 = str.toCharArray();
        String str2 = "";
        for (int i = 0; i < s1.length;i++){
            str2 = s1[i] + str2;

        }
        System.out.println(str2);

}
}