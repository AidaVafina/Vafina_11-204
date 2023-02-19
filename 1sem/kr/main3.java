import java.util.*;
public class main3 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int x = scanner.nextInt();
		int k = 1;
		int sum = 0;
		while (k <= n){

			sum += (Math.pow(-1,k))*((Math.pow(x,(2*k+1)))/(fact(k) + x));
			k ++;

		}
		System.out.println(sum);
	}
		public static int fact(int k){
			if (k = 0){
				return 1;
			}
			return k * fact(k-1);
					
		}
}
