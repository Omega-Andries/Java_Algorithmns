import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Anagram {

	public static void main(String[] args) {
		System.out.println(makeAnagram("cde","abc"));
	}
	
	static int makeAnagram(String a, String b) {
		char letter = 'a';
		int removals = 0;
		
		for(int i =0; i < 26; i++) {
			if(a.contains(letter+"") && b.contains(letter+"")) {
				int aCount = a.length() - a.replace(letter+"", "").length();
				int bCount = b.length() - b.replace(letter+"", "").length();
				
				int nDiff = aCount - bCount;
				
				if(nDiff < 0) {
					nDiff *= -1;
				}
				
				removals += nDiff;
			}else if(a.contains(letter+"")) {
				removals += a.length() - a.replace(letter+"", "").length();
			}else if(b.contains(letter+"")) {
				removals += b.length() - b.replace(letter+"", "").length();
			}
			letter++;
		}
		
		
		return removals;
	}
	
   
}
