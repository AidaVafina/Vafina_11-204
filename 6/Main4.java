import java.util.*;
public class Main4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = scanner.nextInt();
        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        switch (str) {
            case "yellow":
                float countYell = 0;
                float sum = 0;
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        if (k % 2 == 0){
                            if (((i < j) && (i + j == k-1)) || ((i < j) && (i + j >= k))){
                                countYell += 1;
                                sum += matrix[i][j];

                            }
                        } else {
                            if (((i <= j) && (i + j == k-1)) || ((i <= (k / 2)) && (i + j >= k)) || ((i == (k / 2)) && (i < j))){
                                countYell += 1;
                                sum += matrix[i][j];
                            }
                        }
                    }
                }
                float arif = sum / countYell;
                System.out.println(arif);
                break;
            case "green":
                float countGreen = 0;
                float sum1 = 0;
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        if (k % 2 == 0){
                            if (((i == j) && (i + j < k)) || ((j < k / 2) && (i < j))){
                                countGreen += 1;
                                sum1 += 1;
                            }
                        } else {
                            if (((i == j) && (i + j < k)) || ((j <= k / 2) && (i < j))){
                                countGreen += 1;
                                sum1 += 1;
                            }
                        }
                    }
                }
                float arif1 = sum1/countGreen;
                System.out.println(arif1);
                break;
            case "red":
                float countRed = 0;
                float sum2 = 0;
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < k; j++) {
                        if (k % 2 == 0) {
                            if (( (i + j == k-1) && (i > j)) || ((j < k / 2) && (i + j >= k))){
                                countRed += 1;
                                sum2 += 1;
                            }
                        } else {
                            if (((i + j == k-1) && (i >= j)) || ((j <= 3) && (i + j >= k))){
                                countRed += 1;
                                sum2 += 1;
                            }
                        }
                    }

                }
                float arif2 = sum2/countRed;
                System.out.println(arif2);
                break;
        }


    }
}

