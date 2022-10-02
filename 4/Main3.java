import java.util.Scanner;


public class Main3 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = scanner.next();
        }
        for (int i = 0; i < length; i++) {
            char symbol = strings[i].charAt(0);
            if ('A' <= symbol && symbol <= 'Z') {
                System.out.println(strings[i]);
            }
        }
    }
}
