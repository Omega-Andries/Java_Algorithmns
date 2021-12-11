
public class Edge {
	private int eKey;
	private Vertex vert1;
	private Vertex vert2;
	private EdgeState state = EdgeState.UNEXPLORED;
	public Edge(Vertex v1, Vertex v2) {
		this.vert1 = v1;
		this.vert2 = v2;
		
	}

	public Vertex getVert1() {
		return vert1;
	}

	public void setVert1(Vertex vert1) {
		this.vert1 = vert1;
	}

	public Vertex getVert2() {
		return vert2;
	}

	public void setVert2(Vertex vert2) {
		this.vert2 = vert2;
	}

	
	public EdgeState getState() {
		return state;
	}

	public void setState(EdgeState state) {
		this.state = state;
	}

	public int geteKey() {
		return eKey;
	}

	public void seteKey(int eKey) {
		this.eKey = eKey;
	}

	@Override
	public String toString() {
		return vert1 + " ----> " + vert2;
	}
	
	
}
