package dijkstras_algo;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

	protected static enum SearchType {
		LINKED_LIST, MATRIX,
	}

	private boolean[] visited;
	private int[] dist;
	private int[] pi;
	private PriorityQueue<Edge> pq;
	private Graph g;
	static final int INFINITY = Integer.MAX_VALUE;

	public DijkstrasAlgo(Graph g) {
		this.g = g;
		visited = new boolean[g.V];
		dist = new int[g.V];
		pi = new int[g.V];
		pq = new PriorityQueue<Edge>(g.V);

	}

	public void run(int start, SearchType t) {
		init(start);

		switch (t) {
		case LINKED_LIST: {
			LinkedList<Edge>[] adjList = g.adjList;
			pq.add(new Edge(start, start, 0));
			while (!pq.isEmpty()) {
				Edge edge = pq.poll();

				int u = edge.w;
				if (visited[u])
					continue;
				visited[u] = true;
				for (Edge e : adjList[u]) {
					int v = e.w;
					if (!visited[v] && dist[u] != INFINITY && (dist[u] + e.weight < dist[v])) {
						dist[v] = dist[u] + e.weight;
						pi[v] = u;
						pq.add(new Edge(u, v, dist[v]));

					}
				}
			}
			break;
		}
		case MATRIX: {
			int u = 0;
			while ((u = nearestNode(g.V)) != -1) {
				visited[u] = true;
				for (int v = 0; v < g.V; v++) {
					if (!visited[v] && g.adjMatrix[u][v] != 0 && dist[u] != INFINITY
							&& dist[u] + g.adjMatrix[u][v] < dist[v]) {
						dist[v] = dist[u] + g.adjMatrix[u][v];
						pi[v] = u;
					}
				}
			}
		}
		}

	}
	
	private int nearestNode(int v)
	{
		int min = INFINITY;
		int w = -1;
		for (int i = 0; i < g.V; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                w = i;
            }
        }
        return w;
	}

	private void init(int start) {
		for (int i = 0; i < g.V; i++) {
			visited[i] = false;
			dist[i] = INFINITY;
			pi[i] = -1;
		}
		dist[start] = 0;
	}

	private void printPath(int src, int dest) {
		if (dest == src) {
			System.out.print(src + " ");
			return;
		}
		printPath(src, pi[dest]);
		System.out.print(dest + " ");
	}

	public void getPath(int src, int dest) {
		if (dist[dest] == INFINITY) {
			System.out.println("No path from " + src + " to " + dest);
		} else {
			System.out.println("Shortest weight from " + src + " to " + dest + " is " + dist[dest]);
			System.out.print("Path is: ");
			printPath(src, dest);
			System.out.println();
		}
	}

}
