import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int k = scanner.nextInt();
		System.out.println(f(x,k) > 3 ? "count more than 3" : "count less than 3");
}	    
	public static int f(int x, int k){
		int i = 0;
		int c = 1;
		while (x > 0){
            i += (x % k) * c;
            c = c * 10;
            x = x / k;
        }
        int cnt = 0;
        while (i > 0){
        	if (i % 10 == 1){
        		cnt += 1;

        	} 
        	i = i / 10;
        }
        return cnt;
	    }
	    

}