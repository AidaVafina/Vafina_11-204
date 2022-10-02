import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] integers = new int[length];
        for (int i = 0; i < length; i++) {
            integers[i] = scanner.nextInt();
        }
        int d = 0;
        for (int i = 0; i < length; i++) {
            d = Math.abs(integers[1] - integers[0]);
        }
        boolean isProgress = true;
        for (int i = 0; i < length - 1; i++) {
            if (Math.abs(integers[i + 1] - integers[i]) != d) {
                isProgress = false;
            }
        }
        if(isProgress){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}

