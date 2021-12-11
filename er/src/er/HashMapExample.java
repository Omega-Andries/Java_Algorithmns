package er;
import java.util.ArrayList;
import java.util.HashMap;

public class HashMapExample {

	public static void main(String[] args) {
		int arr[] = {3,5,4,1,2};//the arrays
		
		System.out.println("Minimum Swaps = " + minimumSwaps(arr));
	}
 
	static int minimumSwaps(int[] arr) {
    	int minS = 0;

    	boolean[] checked = new boolean[arr.length];
    	
    	for(int i = 0 ; i < arr.length; i++) {
    		if(!checked[i]) {
    			int b = arr[i] -1;
    			int cycle = 1;
    			while(b != i) {
    				checked[b] = true;
    				b = arr[b]-1;
    				cycle++;
    			}
    			minS += cycle-1;
    		}
    	}
    	return minS;
	} 
}