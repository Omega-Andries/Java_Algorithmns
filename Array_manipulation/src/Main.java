import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		//int theArray = 7542539201;
		List<Integer> theArr = new ArrayList<>();
		for( int u = 0; u < 5 ; u++) {
			theArr.add(u);
		}
		
		System.out.println(theArr.toString());
		theArr.remove(theArr.size() -1);
		System.out.println(theArr.toString());
	}

}
