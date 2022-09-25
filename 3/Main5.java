import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
	    boolean flag = false;
		for (int x = 1; x * x <= n; x++){
			for (int y = x; y*y <= n;y++){
				for (int z = y; z*z <= n; z++){
					if (x*x + y*y + z*z == n){
						System.out.println(x);
						System.out.println(y);
						System.out.println(z);
					flag = true;
					}
			    }
			}
		}
	if (flag == false){
		System.out.println("NO");
	}

	    }
	    
}
	
