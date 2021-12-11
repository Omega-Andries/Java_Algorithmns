import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Write a sentence: "); String s = sc.nextLine();//the sentence to test
		System.out.println("Original Sentece: " +s);//show original sentence
		System.out.println("Without punctuations: " + removePunctuations(s));
		sc.close();
	}

	private static StringBuilder removePunctuations(String s) {
		StringBuilder sB = new StringBuilder();
		for(int k = 0; k < s.length(); k++) {
			if(Character.isLetterOrDigit(s.charAt(k)) ||  Character.isWhitespace(s.charAt(k))){
				sB.append(s.charAt(k));
			} 
		}
		return sB;
	}

}
