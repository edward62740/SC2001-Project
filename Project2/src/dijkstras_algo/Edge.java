package dijkstras_algo;

public class Edge implements Comparable<Edge> {

    public int v;
    public int w;
    public int weight;

    public Edge(int v, int w, int weight) {
        if (v < 0) throw new IllegalArgumentException("Index must be non-negative");
        if (w < 0) throw new IllegalArgumentException("Index must be non-negative");
        if (weight < 0) throw new IllegalArgumentException("Weight must be non-negative");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.weight, o.weight);
	}
}