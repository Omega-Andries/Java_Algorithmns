import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		int[] q = {1 ,2, 5, 3, 7, 8, 6, 4};
		minimumBribes(q);
	}
	
    static void minimumBribes(int[] q) {
    	int[] perfectQ = new int[q.length];// perfect Q we will use to compare with the 
    	
    	//enter values to the perfect Q
    	for(int i =0; i < perfectQ.length; i ++) {
    		perfectQ[i] = i+1;
    	}
    	ArrayList<Integer> bribesC = new ArrayList<>();
    	
    	//we loop through the old loops and start comparing from last induvidual till the last
    	int TBribe = 0;
    	for(int k =q.length -1;k > 0; k--) {
    		//before jumping to another loop let's check if there's really a shift
    		if(perfectQ[k] != q[k]) {
    			//Now we found some one not in his position.
    			//Before we look for him, let's make sure he didn't make more than 2 jumps.
    			
    			//ensure we're not checking at 2 for two
    			
    			if(perfectQ[k] != q[k-1] && perfectQ[k] != q[k-2]) {
        			bribesC.add(3);
        			int bribe = 2;
        			//let's fix things
        			while(perfectQ[k] != q[k-bribe]) {
        				bribe++;//count bribes made
        			}
        			TBribe += bribe;
    				int oldQ = q[k];
    				q[k] = perfectQ[k];
    				q[k-bribe] = oldQ;
        		}else {
        			if(perfectQ[k] == q[k-1]) {
        				bribesC.add(1);
        				int oldQ = q[k];
        				q[k] = perfectQ[k];
        				q[k-1] = oldQ;
        				TBribe+=1;
        			}else{
        				bribesC.add(2);
        				int oldQ = q[k];
        				q[k] = perfectQ[k];
        				q[k-2] = oldQ;
        				
        				//final swap
        				int oldP = q[k-1];
        				q[k-1] = q[k-2];
        				q[k-2] = oldP;
        				TBribe+=2;
        			}
        		}
    			
    		}
    	}
    	
    	if(bribesC.contains(3)) {
    		System.out.println("Too chaotic");
    	}else {
    		System.out.println(TBribe);
    	}
    }
}