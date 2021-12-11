import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//demonstrate has function
		if(recCalc(15)) {
			System.out.println("It's a multiple");
		}else {
			System.out.println("It's not a multiple");
		}
	}
	private static boolean recCalc(int n) {
		if(n > 3) {
			return recCalc(n-3);
		}
		
		if(n == 3) {
			return true;
		}else {
			return false;
		}
	}

}
 