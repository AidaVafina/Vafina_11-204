import java.util.*;
public class Main2 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int[][] matrix = new int[k][k];
		
		
		for (int i = 0; i < k; i++){
			for (int j = 0; j < k; j++){
				matrix[i][j] = scanner.nextInt();
				
				
	}
	
}       int sum = 0;
        int cold = 0;
        for (int i =0;i<matrix.length ;i++ ) {
			if (i % 2 == 0){
				for (int j = 0; j<matrix.length; j++){
					if (j % 2 != 0) {
						sum += matrix[i][j];
						cold ++;

					}
				}
			}
		}
		double b = (double)cold;
		double a = (double)sum;

        double arifm = a / b;
        System.out.println(arifm);
}
}
