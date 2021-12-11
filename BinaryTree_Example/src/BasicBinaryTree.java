public class BasicBinaryTree{
	static Node root;
	/*
	 * Create a binary Tree
	 */
	public void createNode(int data) {
		Node newNode = new Node(data);
		
		if(root == null) {
			root = newNode;
			root.parent = root;
		}else {
			searchAdd(root, newNode);
		}
	}
	 
	/*
	 * Delete a node to a binary tree 
	 */
	public static boolean deleteNode(int key) {
		Node nodeToDelete = findNode(root, key);
		System.out.print(nodeToDelete);
		boolean deleted = false;
		if(nodeToDelete != null) {
			/*
			 * Case 1: No children
			 */
			if(nodeToDelete.left ==null && nodeToDelete.right == null) {
				
				deleteCase1(nodeToDelete);
				
				deleted =true;
			}else if(nodeToDelete.left != null && nodeToDelete.right != null) {
				/*
				 * Case 3: 2 children
				 */
				deleteCase3(nodeToDelete);
				deleted =true;
			}else if(nodeToDelete.left != null ) {
				/*
				 * Case 2: One child
				 */
				
				deleteCase2(nodeToDelete);
				deleted =true;
			}else if( nodeToDelete.right != null) {
				/*
				 * Case 2: One child
				 */
				
				deleteCase2(nodeToDelete);
				deleted =true;
			}
		}	
		

		
		return deleted;
	}
	
	private static void deleteCase1(Node nodeToDelete) {
	
		if(nodeToDelete.parent.left == nodeToDelete) {
			System.out.println("Gones is " +nodeToDelete);
			 nodeToDelete.parent.left = null;
		 }else if(nodeToDelete.parent.right == nodeToDelete){
			 nodeToDelete.parent.right = null;
		 }
	}
	
	private static void deleteCase2(Node nodeToDelete) {
		
		if(nodeToDelete.parent.left == nodeToDelete) {
			
			if(nodeToDelete.left != null) {
				nodeToDelete.parent.left = nodeToDelete.left;
			}else if(nodeToDelete.right != null) {
				nodeToDelete.parent.right = nodeToDelete.right;
			}
		}else if(nodeToDelete.parent.right == nodeToDelete) {
			
			if(nodeToDelete.left != null) {
				nodeToDelete.parent.right = nodeToDelete.left;
				//displayAll(root);
				
			}else if(nodeToDelete.right != null) {
				System.out.println(nodeToDelete.left);
				nodeToDelete.parent.right = nodeToDelete.right;
			}
		}
		
	
	}
	
	private static void deleteCase3(Node nodeToDelete) {
		Node minNode = minLeftTriversal(nodeToDelete.right);
		deleteCase1(minNode);
		//give all properties of node to be deleted to the replacement node
		minNode.right = nodeToDelete.right;
		minNode.left = nodeToDelete.left;
		if(nodeToDelete == root) {
			root = minNode;
		}else {
			minNode.parent = nodeToDelete.parent;
			if(nodeToDelete.parent.left == nodeToDelete) {	
				nodeToDelete.parent.left = minNode;
			}else if (nodeToDelete.parent.right == nodeToDelete) {
				//give all properties of node to be deleted to the replacement node
				
				nodeToDelete.parent.right = minNode;
			}
		}
		
		
		
	
	}
	
	/*
	 * Find Minimum left triversal
	 * 
	 */
	private static Node minLeftTriversal(Node minNode) {
		if(minNode.left == null) {
			return minNode;
		}else {
			return minLeftTriversal(minNode.left);
		}
	}
	/*
	 * Add a node to a binary tree
	 */
	public static Node searchAdd(Node root, Node newNode) {
		
		if(newNode.data < root.data) {
			if(root.left !=null) {
				searchAdd(root.left, newNode);
			}else {
				newNode.parent = root;
				root.left = newNode;
			}
		}else {
			if(root.right !=null) {
				searchAdd(root.right, newNode);
			}else {
				newNode.parent = root;
				root.right = newNode;
			}
		}
		
		return newNode;
	} 
	
	
	/*
	 * Find A node in a binary Tree
	 */
	public static Node findNode(Node root,int key) {
		
		if(root != null) {
			if( key < root.data) {
				return findNode(root.left,key);
			}else if(key > root.data) {
				return findNode(root.right,key);
			}else {
				return root;
			}
		}else {
			return null;
		}
	}
	
	private static void displayAll(Node root) {
		if(root !=null) {
			System.out.println(root);
			if(root.left != null) {
				displayAll(root.left);
			}
			
			if(root.right != null) {
				displayAll(root.right);
			}
			
			
		}
	}
	
	
	public static void main(String[] args) {
		BasicBinaryTree bT = new BasicBinaryTree();
		bT.createNode(1);
		bT.createNode(2);
		bT.createNode(3);
		bT.createNode(4);
		bT.createNode(5);
		bT.createNode(6);

		System.out.println();


		displayAll(root);
	}
}