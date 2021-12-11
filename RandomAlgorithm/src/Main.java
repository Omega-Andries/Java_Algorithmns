import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : ");long n = sc.nextLong();
		System.out.print("Enter m : ");long m = sc.nextLong();
		
		if(isMultiple(n, m)) {
			System.out.println("It is a multiple");
			
		}else {
			System.out.println("It is NOT a multiple");
		}
		sc.close();
	}
	
	private static boolean isMultiple (long n, long m) {
		if(n % m ==0) {
			return true;
		}else {
			return false;
		}
	}
}
