import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String binaryString = "";
        int b;
        while (a != 0) {
            b = a % 2;
            binaryString = binaryString + b;
            a = a / 2;
        }
        StringBuilder stringBuilder = new StringBuilder(binaryString);
        binaryString = stringBuilder.reverse().toString();
        System.out.println(binaryString);
        int count = 0;
        int max = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') count++;
            else count = 0;
            if (count > max) max = count;
        }
        System.out.println(max);
    }
}
