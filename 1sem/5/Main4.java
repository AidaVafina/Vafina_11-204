import java.util.*;
public class Main4 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int[][] matrix = new int[k][k];
		for (int i = 0; i < k; i++){
			for (int j = 0; j < k; j++){
				matrix[i][j] = scanner.nextInt();
			}
		}
		int sum = 0;
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length;j++){
				if (i == j){
					sum += matrix[i][j];

				}
			}
		}
		if (sum % 2 == 0){
			System.out.println("true");
		}
		else if (sum % 2 != 0) {
			System.out.println("false");
		}
	}
}
