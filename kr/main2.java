import java.util.*;
public class main2 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int[] arr = new int[a];
		for (int i = 0; i < a; i++){
			arr[i] = scanner.nextInt();
		}
		boolean flag = true;
		for (int i = 0; i < a; i++){
			int v = arr[i];
			int dlin = v.length;
		    while (dlin > 0){
		    	if (v % 2 == 0) {
		    		flag = true;
		    	}else{
		    		flag = false;
		    	}
		    	v = v / 2;

		    }
		    if (flag == true){
		    	System.out.println("YES");
		    	break;
		    }

		    }
		    if (flag == false) {
		    	System.out.println("NO");
		    }
		    
		    
		    
		    }
	}
