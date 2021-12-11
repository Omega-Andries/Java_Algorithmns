import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PQueue<T extends Comparable<T>> {
	// To store tree elements
	ArrayList<Integer> intKeys = new ArrayList<>();
	Node root;
	/**
	 * Insert an element
	 */
	public void addElements(int element) {
		Node newNode = new Node(element);
		if(root == null) {
			root = newNode;
		}else {
			addElements2(root, newNode);	
		}	
	}
	
	/*
	 * to help in adding an element(recursive reasons)
	 */
	private void addElements2(Node parent, Node newNode) {

		if(parent.leftChild == null || parent.rightChild ==null) {//before starting a new length, let's make sure the one we have is full first.
			if( parent.leftChild == null) { 
				parent.leftChild = newNode;
				System.out.println(newNode.element +" added to left and parent is " + parent.element);
				newNode.parent = parent;
			}else if(parent.rightChild == null) {
				parent.rightChild = newNode;
				System.out.println(newNode.element +" added to right and parent is " + parent.element);
				newNode.parent = parent;
			}
		}else {
			if(parent != root) {
				if(parent.parent.leftChild == parent) {
					addElements2(parent.parent.rightChild, newNode);
				}else {
					addElements2(parent.parent.leftChild.leftChild, newNode);
					
				}
			}else {
				
				addElements2(parent.leftChild, newNode);
			}
		}
		
		
	}
	
	/*
	 * order elements
	 */
	
	/*
	 * remove an element
	 */
	
	
	private void preOrderDisplay(Node parent) {
		
		
		System.out.println(parent.toString());
		
		if(parent.leftChild != null) {
			preOrderDisplay(parent.leftChild);
		}	
		
		if(parent.rightChild != null) {
			preOrderDisplay(parent.rightChild);
		}
	}
	
	public void treeDisplay() {
		if(root != null) {
			preOrderDisplay(root);
		}else {
			System.out.println("There is nothing to display dawg");
		}
	}
}
