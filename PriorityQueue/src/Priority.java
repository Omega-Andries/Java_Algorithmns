

public class Priority {
	public static void main(String[] args) {
		PQueue<Integer> pQ = new PQueue<Integer>();
		/*
		 * Add elements to tree
		 */
		pQ.addElements(1);
		pQ.addElements(5);
		pQ.addElements(1);
		pQ.addElements(8);
		pQ.addElements(6);
		pQ.addElements(2);
		pQ.addElements(2);
		pQ.addElements(13);
		pQ.addElements(12);
		pQ.addElements(11);
		pQ.addElements(7);
		pQ.addElements(2);
		pQ.addElements(15);
		pQ.addElements(3);
		pQ.addElements(10);
	
		pQ.treeDisplay();
	}
}