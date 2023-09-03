package dijkstras_algo;

import java.io.FileWriter;
import java.io.IOException;

import dijkstras_algo.DijkstrasAlgo.SearchType;
import dijkstras_algo.Graph.GraphType;


public class Test {
	public static void main(String[] args) throws Exception {
		testPrintGraph();

	}

	/**
	 * Test the printGraph method
	 */
	private static void testPrintGraph() {
		Graph g = null;

		try {
			g = new Graph(8000, 2, GraphType.SPARSE, -1);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		if (g == null)
			return;
		// g.printGraph();
		// System.out.println();
		DijkstrasAlgo algo = new DijkstrasAlgo(g);
		long start, stop;
		start = System.currentTimeMillis();

		algo.run(0, SearchType.MATRIX);

		stop = System.currentTimeMillis();
		/* verify sorted order */
		System.out.println("Time taken: " + (stop - start) + " ms");

		start = System.currentTimeMillis();

		algo.run(0, SearchType.LINKED_LIST);

		stop = System.currentTimeMillis();
		/* verify sorted order */
		System.out.println("Time taken: " + (stop - start) + " ms");
		// for(int i=0; i<50; i++) algo.getPath(0, i);

		try {
			FileWriter csvWriter = new FileWriter("runtimes.csv");
			csvWriter.append("vertices,edges,ll(ms),matrix(ms)\n"); // Header for CSV file

			int vertices = 12000;
			int edges = (vertices*(vertices-1))/2;

			for (int i = 1; i < edges; i*=2) { // array size to 10M
				System.out.println(i);
				g = new Graph(vertices, 100, GraphType.CUSTOM, i);
				algo = new DijkstrasAlgo(g);
				long start1, stop1;
				long start2, stop2;

				start1 = System.currentTimeMillis();
				algo.run(0, SearchType.LINKED_LIST);
				stop1 = System.currentTimeMillis();

				start2 = System.currentTimeMillis();
				algo.run(0, SearchType.MATRIX);
				stop2 = System.currentTimeMillis();

				System.out.println("LL: " + (stop1-start1) + "ms, Matrix: " + (stop2-start2) +" ms");
				// Append data to the CSV file
				csvWriter.append(
						vertices + "," + i + "," + (stop1 - start1) + "," + (stop2 - start2) + "\n");
				algo = null;
				g = null;

			}

			csvWriter.close(); // Close the CSV file writer 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
