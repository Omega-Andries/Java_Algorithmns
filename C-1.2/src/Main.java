
public class Main {
	static String whatE= "";
	public static void main(String[] args) {
		if(someAlgo()) {
			System.out.println(whatE + " It exist");
		}else {
			System.out.println("It Not exist");
		}
	}
	
	private static boolean someAlgo() {
		Integer[] Arr = {1,3,5,6,6,87,4,23,5,7,8,6,42,5,6};
		boolean tIs = false;
		for(int i = 0; i < Arr.length; i++) {
			for(int k = 0; k < Arr.length; k++) {
				int qOddProd = Arr[i] * Arr[k];
				if(qOddProd %2 !=0) {
					tIs = true;
					whatE = Arr[i] +" X " + Arr[k] +" = " + qOddProd;
				}
			}
		}
		return tIs;
	}
}
