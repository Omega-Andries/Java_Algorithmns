
public class BinaryTree {

	Node root;
	/*
	 * Insertion
	 */
	public void addNode(int data, String value) {
		Node newNode = new Node(data, value);
		if(root ==null) {
			root = newNode;//if root is null, make the new node the root
		}else {
			addNode2(root,newNode);
		}
	}
	/*
	 * To assist the addition of nodes with recursion
	 */
	
	private void addNode2(Node parent,Node newNode) {

		/**
		 * Check if it belongs to left or right and add accordingly
		 */
		if(newNode.data <= parent.data) {
			//belongs to the left side
			if(parent.left != null) {
				addNode2(parent.left, newNode);//search the left side till you find the null space for him
			}else {
				//we found space for him ;->)
				parent.left = newNode;
				newNode.parent = parent;// give him his parent :->)
			}
		}
		
		if(newNode.data > parent.data) {
			//belongs to the right side
			
			if(parent.right != null) {
				addNode2(parent.right, newNode);//search the right side till you find the null space for him
			}else {
				//we found space for him ;->)
				parent.right = newNode;
				newNode.parent = parent;// give him his parent :->)
			}
		}
	}
	/*
	 * Finding
	 */
	public Node findNode(Node root,int data) {
		//first let's check if it's root or node
		if(root.data == data) {
			return root;
		}else if(data < root.data) {
			//check on the left side
			return findNode(root.left, data);
		}else if(data > root.data){
			//check on the right side
			return findNode(root.right, data);
		}else {
			return null;//not found
		}
	}
	
	/*
	 * Deleting
	 */
	public void deleteNode(int data) {
		//we have 3 cases to consider when deleting a node in a binary tree

		Node nodeToDelete = findNode(this.root,data);
		/*
		 * For the sake of neatness i'll create 3 extra functions covering each case
		 */
		if(nodeToDelete == null) {//incase some one tries to delete what doesn't exist
			System.out.println("You can't remove what doesn't exist");
		}else if(nodeToDelete.right == null && nodeToDelete.left ==null) {//no child
			delete1(nodeToDelete);
		}else if(nodeToDelete.right != null && nodeToDelete.left != null) {//2 children
			delete3(nodeToDelete);
		}else if(nodeToDelete.right != null || nodeToDelete.left !=null) {//1 child
			delete2(nodeToDelete);
		}
		
		
	}
	
	//no children
	private void delete1(Node nodeToDelete) {
		if(nodeToDelete == this.root) {
			this.root = null;
		}else if(nodeToDelete.parent.left == nodeToDelete) {
			nodeToDelete.parent.left = null;
		}else if(nodeToDelete.parent.right == nodeToDelete) {
			nodeToDelete.parent.right = null;
		}
		
		
	}
	
	//one child
	private void delete2(Node nodeToDelete) {
		//check if it's left or right
		if(nodeToDelete.parent.left == nodeToDelete) {
			//it's left
			if(nodeToDelete.left != null) {
				nodeToDelete.parent.left = nodeToDelete.left;
			}else {
				nodeToDelete.parent.left = nodeToDelete.right;
			}
		}else {
			//it's right
			if(nodeToDelete.left !=null) {
				nodeToDelete.parent.right = nodeToDelete.left;
			}else {
				nodeToDelete.parent.right = nodeToDelete.right;
			}
		}
	}
	
	private Node calcMinLeft(Node nodeToDelete) {
		if(nodeToDelete.left != null) {
			return calcMinLeft(nodeToDelete.left);
		}else {
			return nodeToDelete;
		}
	}
	//2 children
	private void delete3(Node nodeToDelete) {
		Node minLeft = calcMinLeft(nodeToDelete.right);//find the lowest on the left side
		System.out.println(minLeft);
		//delete this and assign it to a new position
		deleteNode(minLeft.data);
		
		//Pass all propeties of the old node to the new node before deleting
		minLeft.left = nodeToDelete.left;
		minLeft.right = nodeToDelete.right;
		if(nodeToDelete == this.root) {
			//this implies it's a root
			minLeft.parent = minLeft;
			this.root = minLeft;
		}else {
			minLeft.parent = nodeToDelete.parent;
			if(nodeToDelete.parent.left == nodeToDelete) {
				nodeToDelete.parent.left = minLeft;
			}else {
				nodeToDelete.parent.right = minLeft;
			}
		}
		
	}
	
	
	//Display All nodes
	public void displayAll(int c) {		
		if(root != null) {
			System.out.print("{ ");
			displayE(root, c);
			System.out.print(" }");
			System.out.println();
		}
	}
	
	private void displayE(Node n, int c) {
		
		if(c == 1 || c == 4) {
			System.out.print(n.getValue() +", ");
		}
		
		if(n.left != null) {
			displayE(n.left,c);
		}
		
		if(c == 3 || c == 4) {
			System.out.print(n.getValue() +", ");
		}
		
		if(n.right != null) {
			displayE(n.right,c);
		}
		
		if(c == 2 || c == 4) {
			System.out.print(n.getValue() +", ");
		}
		
		
	}

	public BinaryTree() {

	}
}
