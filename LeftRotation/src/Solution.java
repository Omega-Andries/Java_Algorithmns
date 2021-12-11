
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-nerated method stub
		int[] a = {1,2,3,4,5};
		int[] a2 = rotLeft(a, 4);//The second array
		for(int i = 0; i < a2.length; i++) {
			System.out.print(a2[i] + " ");
		}
	}
	
    static int[] rotLeft(int[] a, int d) {

    	int[] a2 = new int[a.length];//a rotate array to return
    	for(int o =0; o < a2.length; o++) {
    		int diff = o-d; // we use this to get new index position
    		while(diff < 0) {
    			diff +=a.length; //remove it outside the negatives
    		}
    		//now let's get the mod
    		diff = diff%a2.length;
    		
    		a2[diff] = a[o];//replace indexes
    	}
    		
    	return a2;
    }
	
}
