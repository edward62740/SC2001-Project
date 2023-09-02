package dijkstras_algo;

public class Edge implements Comparable<Edge> {

    public int v;
    public int w;
    public double weight;

    public Edge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("Index must be non-negative");
        if (w < 0) throw new IllegalArgumentException("Index must be non-negative");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return Double.compare(this.weight, o.weight);
	}
}