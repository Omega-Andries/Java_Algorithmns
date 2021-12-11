import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private int vKey = 0;
	private String vData = "";
	
	private NodeState state = NodeState.UNEXPLORED;
	List<Edge> edges = new ArrayList<>();
	
	public Vertex(int k, String data) {
		this.vKey = k;
		this.vData = data;
	}

	public int getvKey() {
		return vKey;
	}

	public void setvKey(int vKey) {
		this.vKey = vKey;
	}

	public String getvData() {
		return vData;
	}

	public void setvData(String vData) {
		this.vData = vData;
	}

	@Override
	public String toString() {
		return this.vData;
	}

	public NodeState getLabel() {
		return state;
	}

	public void setLabel(NodeState state) {
		this.state = state;
	}

	public NodeState getState() {
		return state;
	}

	public void setState(NodeState state) {
		this.state = state;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	
}	

