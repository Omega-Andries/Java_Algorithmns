import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class graph {
	
	private static GraphType gType;
	public static void main(String[] args) {
		List<Vertex> vertices = new ArrayList<>();
		List<Edge> edges = new ArrayList<>();
		int key = 1;
		char data = 'a'; 
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("What Type Of Graph Are You Creating: ");
		System.out.println("1. DIRECTED: ");
		System.out.println("2. UNDIRECTED: ");
		int tN = scan.nextInt();
		if(tN == 1) {
			gType = GraphType.DIRECTED;
		}else {
			gType = GraphType.UNDIRECTED;
		}
		
		
		System.out.print("Please Enter The Number Of Vertices: " ); int nV = scan.nextInt();
		System.out.print("Please Enter The Number Of Edges: " ); int nE = scan.nextInt();
		
		while(key <= nV) {
			Vertex v = new Vertex(key,data+"");
			vertices.add(v);
			data++;key++;
		}
		
		
		for(int y =0; y < nE; y++) {
			
			
			int thing = y+1;
			
			System.out.print("For e"+thing+" Enter Key vertex1: ");int k1 = scan.nextInt();
			System.out.print("For e"+thing+" Enter Key vertex2: ");int k2 = scan.nextInt();
			
			Vertex vertex1 = findVertex(k1,vertices);
			Vertex vertex2 = findVertex(k2,vertices);
			if(vertex1 == null || vertex2 == null) {
				System.out.println("FUCK IT ALLLLLLLL");
				break;
			}
			
			Edge edge = new Edge(vertex1,vertex2);
			
			
			edge.seteKey(thing);
			edges.add(edge);
			
		}
		
		for(Vertex v: vertices) {
			List<Edge> emEs = new ArrayList<>();
			for(Edge e: edges) {
				if(e.getVert1() == v || e.getVert2() ==v) {
					emEs.add(e);
				}
			}
			v.setEdges(emEs);
		}

		
		megraph theG = new megraph(vertices,edges, gType);
		boolean operate = true;
		do {
			System.out.println("The Graph Has been Made, What To Do?");
			System.out.println("1. Check Strong Connectivity(Directed tingz)");
			System.out.println("2. DFS Display");
			System.out.println("3. BFS Display");
			System.out.println("4. FUCK THIS");
			int c = scan.nextInt();
			switch (c) {
			case 1:
				if(strongConnectivityAlgo(theG, vertices.get(0))) {
					System.out.println("It is strongly connected");
				}else {
					System.out.println("It is not strongly connected");
				}
				break;
			case 2:
				System.out.print("From: ");
				for(Vertex v: vertices) {
					System.out.print(" Key:"+v.getvKey()+" value:"+v);
				}
				System.out.println("Where Would You Like To Start: ");
				int kDFS = scan.nextInt();
				DFSDisplay(theG, findVertex(kDFS, vertices));
				break;
			case 3:
				System.out.print("From: ");
				for(Vertex v: vertices) {
					System.out.print(" Key:"+v.getvKey()+" value:"+v);
				}
				System.out.println("Where Would You Like To Start: ");
				int kBFS = scan.nextInt();
				BFSDisplay(theG, findVertex(kBFS, vertices));
				break;
			case 4:
				operate = false;
				scan.close();
				break;

			default:
				break;
			}
			
		}while(operate);
		/*
		 * 
		
		DFSDisplay(theG, vertices.get(0));
		if(gType == GraphType.DIRECTED) {
			if(strongConnectivityAlgo(theG, vertices.get(0))) {
				System.out.println("It is strongly connected");
			}else {
				System.out.println("It is NOT strongly connected");
			}
		}
		 */
		
	}
	
	private static void BFSDisplay(megraph theG, Vertex findVertex) {
		if(theG.getType() == GraphType.DIRECTED) {
			System.out.println("BFS Display");
			for(Vertex v : theG.getAmaVertices()) {
				if(v.edges.size() == 0) {
					System.out.println(" " +v +", ");
				}
			}
			System.out.println("{ " +findVertex +", ");
			for(Edge eedge: findVertex.edges) {
				
				if(eedge.getVert1() == findVertex) {
					if(eedge.getVert2().getState() == NodeState.UNEXPLORED) {
						System.out.println(eedge.getVert2()+ " ,");
					}else {
						System.out.println(" }");
						break;
					}
				}
				
			}
			
		}else {
			
		}
	}

	private static Vertex findVertex(int k,List<Vertex> vertices){
		Vertex vet = null;
		for(Vertex V: vertices) {
			if(V.getvKey() == k) {
				vet = V;
				break;
			}
		}
		return vet;
	}
	

	private static void DFSDisplay(megraph theeG,Vertex v) {
		if(theeG.getType() == GraphType.DIRECTED) {
			int eN = 1;
			for(Edge e : theeG.getAmaEdges()) {
				System.out.println("For Edge " + eN);
				System.out.println(e);
				
				eN++;
			}
		}else {
			v.setState(NodeState.EXPLORED);
			Edge e = v.edges.get(0);
			System.out.println(v + ", ");
				for(int r = 0 ; r< v.edges.size(); r++) {
					e = v.edges.get(r);
					
					if(e.getState() == EdgeState.UNEXPLORED) {
						e.setState(EdgeState.DISCOVERY);
						if(e.getVert2().getLabel() == NodeState.UNEXPLORED) {
							
							
							
							if(e.getVert2().edges.size() == 1) {
								System.out.println(e.getVert2() + ", ");
								e.getVert2().setState(NodeState.EXPLORED);	
							}else {
								v = e.getVert2();
								v.setLabel(NodeState.EXPLORED);
								System.out.println(v);
								r = 0;
							}
							
							
							}else {
								e.setState(EdgeState.BACKEDGE);
								System.out.println("Setting E " + e.geteKey() + " To back");

							}
			
					}
					
					
					
				}
				System.out.println();

		}
	}
	
	private static boolean strongConnectivityAlgo(megraph G, Vertex v) {
		boolean strong = true;
		
		G = DFSVisit(G,v);
		
		for(Vertex vert : G.getAmaVertices()) {
			if(vert.getLabel() == NodeState.UNEXPLORED) {
				strong = false;
				break;
			}
		}
		
		if(strong) {
			G = resetGraph(G);
			megraph GPrime = reverseGraph(G);
			GPrime = DFSVisit(GPrime,v);
			for(Vertex vert1: GPrime.getAmaVertices()) {
				if(vert1.getLabel() == NodeState.UNEXPLORED) {
					strong = false;
					break;
				}
			}
		}
		return strong;
	}

	private static megraph reverseGraph(megraph g) {
		
		List<Edge> newEdges = new ArrayList<>();
		for(Edge e : g.getAmaEdges()) {
			Edge edge = new Edge(e.getVert2(),e.getVert1());
			newEdges.add(edge);
		}
		
		return new megraph(g.getAmaVertices(), newEdges,g.getType());
	}

	private static megraph resetGraph(megraph g) {
		
		for(Vertex v: g.getAmaVertices()) {
			v.setLabel(NodeState.UNEXPLORED);
		}
		return g;
	}

	private static megraph DFSVisit(megraph g, Vertex v) {
		megraph vG =null;
		// look for the starting edge
		Edge startE = null;
		for(Edge e : g.getAmaEdges()) {
			if(e.getVert1() == v) {
				startE = e;
				break;
			}
		}
		
		if(startE != null) {
			for(Edge e : g.getAmaEdges()) {
				
				e.getVert1().setLabel(NodeState.EXPLORED);
				
			}
			vG = g;
		}
		return vG;
	}
}
