package dijkstras_algo;

import java.util.LinkedList;
import java.util.Random;

public class Graph {
	public int V, E;
	public int adjMatrix[][];
	public LinkedList<Edge>[] adjList;
	

	public static enum GraphType {
		DENSE,
		SPARSE,
		FC,
	}
	public static final long SEED = 1234L;
	
	public Graph(int v) {
		V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<>();
		}
		adjMatrix = new int[v][v];
	}


	public Graph(int V, int maxWeight, GraphType type) {

		// generate sparse graph
		Random rand = new Random(SEED);
		this.V = V;
		adjList = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new LinkedList<>();
		}
		adjMatrix = new int[V][V];
		
		int edges = 0;
		switch(type)
		{
		case DENSE:
			edges = (V - 1) * V;
			break;
		case SPARSE:
			edges = V - 1;
			break;
		default:
			break;
			
		}
		for (int i = 0; i < edges; i++) {
			int src = rand.nextInt(V);
			int dest = rand.nextInt(V);
			if (src != dest && !isConnected(src, dest)) {
				int weight = rand.nextInt(maxWeight);
				addEdge(src, dest, weight);
			} else
				i--;
		}

	}

	public void addEdge(int src, int dest, int weight) {
		Edge edge = new Edge(src, dest, weight);
		adjList[src].addFirst(edge);
		adjMatrix[src][dest] = weight;
		E++;
	}

	public void printGraph() {
		for (int i = 0; i < V; i++) {
			LinkedList<Edge> list = adjList[i];
			for (int j = 0; j < list.size(); j++) {
				System.out.println(
						"vertex " + i + " is connected to " + list.get(j).w + " with weight " + list.get(j).weight);
			}
		}
	}

	public boolean isConnected(int src, int dest) {
		if (adjMatrix[src][dest] != 0) return true;
		else return false;
	}
}
