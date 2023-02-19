import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int len = Scanner.nextInt();
        int[] a = new int[len];
        for (int i=0;i<len;i++) {
            a[i] = Scanner.nextInt();
        }
        sort(a);
        sortopt(a);
    }

    public static void sort(int[] arr) {
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                c ++;
                if (arr[i] < arr[j]) {
                    int currEl = arr[i];
                    arr[i] = arr[j];
                    arr[j] = currEl;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(c);

    }

    public static void sortopt(int[] arr){
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                c ++;
                if(arr[i] > arr[j]){
                    int currEl = arr[i];
                    arr[i] = arr[j];
                    arr[j] = currEl;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(c);
    }
}