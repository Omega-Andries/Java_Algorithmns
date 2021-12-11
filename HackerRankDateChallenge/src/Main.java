import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

    	try {
        	System.out.print("Please enter x ");			int x = scanner.nextInt();

        	System.out.print("Please enter y ");			int y = scanner.nextInt();

			int out = (int) x/y;System.out.println(out);
			
		} catch (InputMismatchException iE) {
			System.err.println(iE.getClass().getName());
		} catch(ArithmeticException aE) {
			aE.printStackTrace();
		}
    	scanner.close();
    }

    private static long power(int n, int p) throws Exception {
    	
    	if((n < 0) || (p < 0)) {
    		throw new Exception("n or p cannot be negative");
    	}else if((n ==0) && (p ==0)) {
    		throw new Exception("n and p cannot be zero");
    	}else {
    		return (long) Math.pow(n, p);
    	}
    }
}
