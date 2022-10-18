import java.util.*;
public class main4 {
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
		int c = 0;
		for (int i = 0; i < k; i++){
			for (int j = 0; j < k; j++){
				if ((i+j == 6) || (i == j)){
					sum += matrix[i][j];
					c ++;


				}else if ((i < j) && (i + j) <= 5 || (i > j) && (i+j) > 6){
					sum += matrix[i][j];
					c ++;
				}
		double sumd = (double)sum;
		double cd = (double)c;
		double arif = sum / c;
		System.out.println(arif);


}
}