import java.util.*;
public class Main3 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int[][] matrix = new int[k][k];
		for (int i = 0; i < k; i++){
			for (int j = 0; j<k; j++){
				matrix[i][j] = i + j;
			}
		}
		printMatrix(matrix);
}
        public static void printMatrix(int[][] matrix){
		for (int i =0;i<matrix.length ;i++ ) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
