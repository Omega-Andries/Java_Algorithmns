import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class DequeAlgo{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : "); int n = sc.nextInt();
		System.out.print("Enter m : "); int m = sc.nextInt();
		
		Deque dQ = new ArrayDeque<>();
		if(m >n) {
			//if it get's here, it won't be able to close the scanner, so we should close
			sc.close();
			throw new Exception("Please Make Sure m > n");	//Incase a user enters a subarray size that is greater than the actual array
		}else {
		
			for(int y =1; y <= n ;y++ ) {
				int arrValue = sc.nextInt();// now keep adding array values
				dQ.add(arrValue);
			}
			
			/**
			 * Now we N added values, we should proceed to go through all them
			 */
			int max =0;
			int unique; //to count each unique value in the array
			ArrayList<Integer> arrL;
			Iterator iter;
			while(dQ.size() >= m) {//we will keep removing the first object
				unique = 0;
				arrL = new ArrayList<>();//i prefer arraylist over regular arrays, and it was not stated which one to use
				iter = dQ.iterator();// will be used to enter each array value, in each subarray
				for(int p =0 ; p < m ; p++) {
					arrL.add((int)iter.next());
				}
				
				/**
				 * Now we can count unique values
				 */
				while(arrL.size()>0) {
					int vCheck = arrL.get(0);// the value to check
					//now we have to remove it from the array to ensure that it doesn't count itself
					arrL.remove(0);
					if(!arrL.contains(vCheck)) {
						//if it's not there after removal, then it was unique
						unique++;
					}
				}
				
				if(unique > max) {
					max = unique;
				}
				
				//remove the first value
				dQ.removeFirst();
				
			}
			

			// We can finally display our result
			System.out.println("Max Unique = " +max);
			sc.close();//we need to close scanner in if, in case the programme crushes before exiting
		}
		
	}
}