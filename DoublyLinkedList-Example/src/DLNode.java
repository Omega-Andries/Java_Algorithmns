
public class DLNode {
	Node head; //head of list
	/**
	 * Node of a doubly linked list
	 * @author Andries Chimule
	 *
	 */
	class Node {
		int data;
		Node next;
		Node prev;
		
		Node(int d){
			this.data = d;
		}
		
		/**
		 * Adding a node at the front of the list
		 * 
		 */
		private void push(int new_data) {
			/**
			 * 1. allocate node
			 * 2.put in the data
			 */
			Node new_Node = new Node(new_data);
			
			//make next of new node head and previous null
			new_Node.next = head;
			new_Node.prev = null;
			
			if(head != null) {
				head.prev = new_Node;
			}
			
			head = new_Node;
		}
		/**
		 * Insert a node after a given node
		 */
		private void InsertAfter(Node prev_Node, int new_Data) {
			//make sure the given node is not null
			if(prev_Node ==null) {
				System.err.println("Prev node is null");
				return;
			}
			
			/**
			 * Allocate node
			 * put in the data
			 */
			
			Node new_Node = new Node(new_Data);
			
			//Make next of new node next of previous node
			new_Node.next = prev_Node.next;
			
			//make previous of new node previous node
			new_Node.prev = prev_Node;
			
			if(new_Node.next != null) {
				new_Node.next.prev = new_Node;
			}
		}
	}
}
