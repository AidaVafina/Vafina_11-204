import java.util.Arrays;
import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = new String[scanner.nextInt()];
        scanner.nextLine();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextLine();
        }

        int m = scanner.nextInt();
        scanner.nextLine();
        String[][] digits = new String[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                digits[i][j] = scanner.nextLine();
            }
        }
        System.out.println(check(digits, numbers));

    }

    public static boolean check(String[][] digits, String[] numbers) {
        int count = 0;
        for (String[] digit : digits) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (convertArrayToString(digit).contains(numbers[j]) |
                        convertArrayToString(digit).contains(numbers[j + 1])) {
                    count++;
                }
            }
        }
        for (String[] digit : digits) {
            System.out.println(Arrays.toString(digit));
        }
        System.out.println(Arrays.toString(numbers));
        return count == 2;

    }

    public static String convertArrayToString(String[] digits) {
        String s = "";
        for (String digit : digits) {
            s += digit;
        }
        return s;
    }

    public static boolean contains(String str1, String str2) {
        if (str1.length() <= str2.length()) {
            for (int i = 0; i < str2.length() - str1.length(); i++) {
                boolean k = true;
                for (int j = 0; j < str1.length(); j++) {
                    if (str1.charAt(j) != str2.charAt(j + i)) {
                        k = false;
                        break;
                    }
                }
                if (k) {
                    return true;
                }
            }
        }
        return false;

    }
}