
class Node {
	int data;
	Node left;
	Node right;
	Node parent;
	public Node() {
	
	}
	
	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
	
}
