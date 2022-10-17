import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int k = scanner.nextInt();
		System.out.println(f(x,k));

}	    

	public static int f(int x,int k){
		int i = 0;
		int c = 1;
		while (x > 0){
			i += (x % k) * c;
            c = c * 10;
			x = x / k;

		}
		return i;

	    }


}