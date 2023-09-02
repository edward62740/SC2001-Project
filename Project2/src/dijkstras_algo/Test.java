package dijkstras_algo;

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
        Graph g = new Graph(2500, 2, GraphType.DENSE);
        /*
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(0, 4, 8);
        g.addEdge(1, 3, 4);
        g.addEdge(1, 4, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 1);
        g.addEdge(3, 4, 3);
        */
        //g.printGraph();
        //System.out.println();
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
        //for(int i=0; i<50; i++) algo.getPath(0, i);
    }

}
