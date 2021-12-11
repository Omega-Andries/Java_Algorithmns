import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter i: ");int i = sc.nextInt();
		if(isOdd(i)) {
			System.out.println(i+ " is an odd number");
		}else {
			System.out.println(i+ " is not an odd number");
		}
		sc.close();
	}
	private static boolean isOdd(int i) {
		if((i &1) ==1) {
			return true;
		}else {
			return false;
		}
	}

}
