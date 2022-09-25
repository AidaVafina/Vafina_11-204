import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		for (int p = a; p <= b; p++){
			if (coldel(p) == 2){
				System.out.println(p);
			}
		}
}	    
	
	public static int coldel(int n){
		int i = 1;
		int c = 0;
		while (i <= n){
			if (n % i == 0){
				c += 1;

			}
		i ++;
		}

    return c;
	}    

}