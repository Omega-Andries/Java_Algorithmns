
public class Node {
	int data;
	String value;
	Node parent;
	Node left;
	Node right;
	Node root;
	public Node() {
		// TODO Auto-generated constructor stub
	}

	public Node(int data, String value) {
		super();
		this.data = data;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [data=" + this.value + "]";
	}
	
	public String getValue() {
		return this.value;
	}
	
	public int getKey() {
		return this.data;
	}
	
}
