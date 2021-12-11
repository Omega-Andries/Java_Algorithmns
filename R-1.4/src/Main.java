import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter n: ");int n = sc.nextInt();//enter n
		System.out.println("The sum all positive integers less than and equal to " + n + " = "  + sum(n));//display results
		sc.close();//close the scanner
	}
	/**
	 * 
	 * @param n for an integer to be evaluated
	 * @return sum of integers less than and equal to n
	 */
	private static int sum(int n) {
		//starting from 1
		int i =1;
		//sum that will be returned
		int sum = 0;
		while(i <=n) {
			sum += i;//keep incrementing till we get to n;
			i++;
		}
		return sum;
	}

}
