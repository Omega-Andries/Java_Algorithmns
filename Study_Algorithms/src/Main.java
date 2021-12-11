import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Something: ");
		int u = sc.nextInt();
		if(recCalc(u)) {
			System.out.println("It is a multiple");
		}else {
			System.out.println("Its not a multiple");
		}
		sc.close();
	}
	
	/**
	 * 
	 * @param n a parameter to test
	 * @return a boolean (true/false)
	 */
	public static boolean recCalc(int n) {
		//check if n is 3, if it is then n is a multiple of 3
		if ( n ==3) {
			return true;
		} else if(n < 3 && n !=0) {//if n is less than 3 and not equal to 0 then it is not a multple of 3
			System.out.println(n +" " + false);
			return false;
			
		}else {
			// we keep decreasing n by 3 till it's equal to 3 or less than 3 to verify if it's a multiple of 3 or not
			return recCalc(n-3);
		}
		
	}
}
