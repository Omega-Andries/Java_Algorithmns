import java.util.ArrayList;
import java.util.Arrays;

public class BChainMain {

	public static void main(String[] args) {
		String msg = "Hi, I'm your true love";
		int hash = msg.hashCode();
		
		System.out.println("Message = " + msg + " Hash = " +hash);
		
		String[] ar1 = {"Kingz","Dogg","lovey"};
		String[] ar2 = {"Kingz","Dogg","lovey"};
		
		int h1 = Arrays.hashCode(ar1);int h2 = Arrays.hashCode(ar2);
		
		ArrayList<Block> blockChain = new ArrayList<>();
		
		//First Block
		String initialData[] = {"Dan has R500 000", "Omega has R670 000"};
		Block firstBlock = new Block(initialData, 5);
		System.out.println("First Block = " + firstBlock.toString());
		blockChain.add(firstBlock);
		System.out.println("Block Chain = " + blockChain.toString());
		
		//Second Block
		String secondData[] = {"Capitec has R530 000", "Absa has R640 000"};
		Block secondBlock = new Block(secondData, firstBlock.getBlockHash());
		System.out.println("Second Block = " + secondBlock.toString());
		blockChain.add(secondBlock);
		System.out.println("Block Chain = " + blockChain.toString());
	}

}
