import java.util.Arrays;

public class Block {
	private String[] transactions;
	private int blockHash; 
	private int previousBHash;
	
	
	public Block(String[] transactions, int previousBHash) {
		super();
		this.transactions = transactions;
		this.previousBHash = previousBHash;
		this.blockHash = Arrays.hashCode(new int[] {Arrays.hashCode(this.transactions),this.previousBHash});
	}
	public String[] getTransactions() {
		return transactions;
	}
	public void setTransactions(String[] transactions) {
		this.transactions = transactions;
	}
	public int getBlockHash() {
		return blockHash;
	}
	public void setBlockHash(int blockHash) {
		this.blockHash = blockHash;
	}
	public int getPreviousBHash() {
		return previousBHash;
	}
	public void setPreviousBHash(int previousBHash) {
		this.previousBHash = previousBHash;
	}
	@Override
	public String toString() {
		return "Block [transactions=" + Arrays.toString(transactions) + ", blockHash=" + blockHash + ", previousBHash="
				+ previousBHash + "]";
	}
	
	
	
}
