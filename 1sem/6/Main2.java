import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String[] arr = new String[k];
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            arr[i] = scanner.nextLine();
        }
        startstring(arr, k);
    }

    public static void startstring(String[] a, int k) {
        int c = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                boolean flag = false;

                if (a[i].length() <= a[j].length() && i != j) {
                    char[] arr2 = a[j].toCharArray();
                    char[] arr3 = a[i].toCharArray();

                    for (int l = 0; l < arr3.length; l++) {
                        if (arr2[l] == arr3[l]) {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag == true) {
                    System.out.println(a[i]);
                    c++;
                }
            }
        }
        if (c == 0) {
            System.out.println("no strings");
        }
    }
}
