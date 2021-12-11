
import java.util.Scanner;

public class Main  {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bT = new BinaryTree();
		 Scanner sc = new Scanner(System.in);
		 System.out.print("How many nodes would you like to add: ");int nNodes = sc.nextInt();
		 System.out.println();
		 for(int p = 0; p < nNodes; p++) {
			 System.out.print("What is the nodes key: ");int key =  sc.nextInt();
			 System.out.println();
			 System.out.print("What is the nodes value: "); String value = sc.next();
			 System.out.println();
			 bT.addNode(key, value);
		 }
		 
		 boolean travers = true;
		 do {
			 System.out.println("How would you like to traverse?");
			 System.out.println("1 -> PreOrder traversal");
			 System.out.println("2 -> PostOrder traversal");
			 System.out.println("3 -> InOrder traversal");
			 System.out.println("4 -> Euler Tour Traversal");
			 System.out.println("5 -> Check common ancestor");
			 
			 int choice = sc.nextInt();
			 
			 bT.displayAll(choice);
			 
			 System.out.println("Traverse Again?");
			 System.out.println("1 -> YES");
			 System.out.println("2 -> NO");
			 int t = sc.nextInt();
			 if(t == 2) {
				 travers = false;
				 System.out.println("Bye");
			 }
		 }while(travers);
		 
		 sc.close();
			
	}

}
 