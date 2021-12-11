
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Challenge {

	public static void main(String[] args) {
		
		System.out.println(repeatedString("aab", 10));
	}
	
	public static long repeatedString(String s, long n) {
		
			long aCount =0;
			Pattern pattern = Pattern.compile("[^a]*a");
			Matcher match = pattern.matcher(s);
			
			while(match.find()) {
				aCount++;
			}
			long initialAs = aCount;
			if(aCount == s.length()) {
				return n;
			}else if(aCount ==0){
				return 0;
			}else {
				if(n % s.length() ==0) {
					aCount = aCount * (n/s.length());
				}else {
					long remainder = n % s.length();
					int i =0;
					aCount = initialAs * ((n-remainder)/s.length());
					while(i < remainder) {
						if(s.charAt(i) == 'a') {
							aCount++;
						}
						i++;
					}
				}
				return aCount;
			}
			
	}
}