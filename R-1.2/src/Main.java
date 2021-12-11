import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter N: ");long n = sc.nextLong();
		System.out.print("Enter M: ");long m = sc.nextLong();
		if(isMultiple(n,m)) {
			System.out.println("M is a multiple of N");
		}else {
			System.out.println("M is not a multiple of N");
		}
	}	
	
	private static boolean isMultiple(long n, long m) {
		if(n%m ==0) {
			return true;
		}else {
			return false;
		}
	}

}
