import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Give the nth: ");int n = sc.nextInt();//get the input
		System.out.println(createFibbonaci(n));
		
		sc.close();
	}
	

	
	
	//fibonnaci
	private static int createFibbonaci(int n) {
		int[] arrFibo = new int[n+1];// the fibbonacci sequence;
		
		/**
		 * Create the fibonnacci
		 */
		int i = 0;
		arrFibo[0] = 0;
		arrFibo[1] = 1;
		for(int k = 1; k < n; k++) {

			arrFibo[k+1] = arrFibo[k] + arrFibo[k-1];
		}
		System.out.println(Arrays.toString(arrFibo));
		return arrFibo[n];
	}
}
