import java.util.*;
public class Main1 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int[][] matrix = new int[k][k];
		int sum = 0;
		for (int i = 0; i < k; i++){
			for (int j = 0; j < k; j++){
				matrix[i][j] = scanner.nextInt();
				sum += matrix[i][j];
			}
		}
		System.out.println(sum);
	

	}
	
}