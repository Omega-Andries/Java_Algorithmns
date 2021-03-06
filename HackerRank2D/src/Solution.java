import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		int arr[][] = new int[6][6];
		String[] str = {"-9, -9, -9,  1, 1, 1"," 0, -9,  0,  4, 3, 2","-9, -9, -9,  1, 2, 3",
				" 0,  0,  8,  6, 6, 0"," 0,  0,  0, -2, 0, 0"," 0,  0,  1,  2, 4, 0"};
		Scanner sc = new Scanner(System.in);
		for(int i =0; i < 6; i++) {
			StringTokenizer strTk = new StringTokenizer(str[i], ", ");
			for(int j = 0 ; j < 6; j++) {
				int value = Integer.parseInt(strTk.nextToken());
				arr[i][j] = value;
			}
		}
		
		System.out.println(hourglassSum(arr));
		sc.close();
	}
	
	private static int hourglassSum(int arr[][]) {
		int maxSum =0;
		int[] Sums = new int[16];
		int f =0;
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j < 5; j++) {
				int sum = arr[i][j] + arr[i-1][j-1] + arr[i-1][j]+arr[i-1][j+1]+arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];
				
				Sums[f] = sum;
				
				f++;
			}
		}
		maxSum = Sums[0];
		for(int o =0; o < Sums.length; o++) {
			if(Sums[o] > maxSum) {
				maxSum = Sums[o];
			}
		}

		return maxSum;
	}
	
	
}
