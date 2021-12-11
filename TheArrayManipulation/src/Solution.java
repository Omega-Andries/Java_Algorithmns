import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		int qS[][] = new int[4][3];
		String str[] = {"2, 6, 8","3, 5, 7","1 ,8 ,1","5, 9, 15"};
				
		for(int k = 0; k < 4; k++) {
			StringTokenizer strTK = new StringTokenizer(str[k] , ", ");
			for (int y = 0; y < 3; y++) {
				qS[k][y] = Integer.parseInt(strTK.nextToken());
			}
		}
		

		System.out.println(arrayManipulation(10, qS));
		
	}
    static long arrayManipulation(int n, int[][] queries) {
    	long maxSum = 0;
    	
    	int arrADD[] = new int[n];//an array we will add to;
    	for(int i = 0; i < n ; i++) {
    		arrADD[i] = 0;//add zeros
    	}
    	
    	int rIndex = 0; //To go through all rows of the queries
    	System.out.println(queries.length);
    	while(rIndex < queries.length) {
    		if(queries[rIndex][0] -1 == queries[rIndex][1] -1) {
    			
    			arrADD[queries[rIndex][0] -1]+=queries[rIndex][2];
    			if(arrADD[queries[rIndex][0] -1] > maxSum) {
    				maxSum = arrADD[queries[rIndex][0] -1];
    			}
    		}else {
    			System.out.println( queries[rIndex][0]+" -> " +queries[rIndex][1]);
    			
    			for(int v = queries[rIndex][0] -1; v <= queries[rIndex][1] -1;v++) {
    				System.out.print("; "+v + " "+arrADD[v] + " + ");
        			arrADD[v]+=queries[rIndex][2];
        			System.out.print(queries[rIndex][0]+ " = " +arrADD[v]);
        			
        		
        			if(arrADD[v] > maxSum) {
        				maxSum = arrADD[v];
        			}
        		}
    			System.out.println();
    		}
    		
    		rIndex++;
    	}
    	return maxSum;
    }
}
