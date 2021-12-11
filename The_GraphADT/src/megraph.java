import java.util.ArrayList;
import java.util.List;

public class megraph {
	private List<Vertex> amaVertices = new ArrayList<>();
	private List<Edge> amaEdges = new ArrayList<>();
	private GraphType Type;
	public megraph(List<Vertex> amVs, List<Edge> amaEs, GraphType t){
		this.amaVertices = amVs;
		this.amaEdges = amaEs;
		this.Type = t;
	}

	public List<Vertex> getAmaVertices() {
		return amaVertices;
	}

	public void setAmaVertices(List<Vertex> amaVertices) {
		this.amaVertices = amaVertices;
	}

	public List<Edge> getAmaEdges() {
		return amaEdges;
	}

	public void setAmaEdges(List<Edge> amaEdges) {
		this.amaEdges = amaEdges;
	}

	public GraphType getType() {
		return Type;
	}

	public void setType(GraphType type) {
		Type = type;
	}
	
	
	
}
