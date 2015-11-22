
public class DirectedEdge {
	
	
	private int v;
	private int w;
	private double weight;

	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	int from() {

		return v;
	}

	int to() {
		return w;
	}

	double weight() {
		return weight;
	}


}
