import java.util.*;
public class Main5 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int[] arr = new int[k];
		for (int l = 0; l < k; l++){
			arr[l] = scanner.nextInt();
		}
		for (int i = 0; i < k; i++){
			int minInd = i;
			int min = arr[i];
			for (int j = i + 1; j < k; j++){
				if (arr[j] < min){
					minInd = j;
					min = arr[j];
				}
			}
		arr[minInd] = arr[i];
		arr[i] = min;
		}
		System.out.println(Arrays.toString(arr));

	}
	
}