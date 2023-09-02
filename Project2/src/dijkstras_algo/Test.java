package dijkstras_algo;

public class Test {
    public static void main(String[] args) throws Exception {
        testPrintGraph();

    }

    /**
     * Test the printGraph method
     */
    private static void testPrintGraph() {
        Graph g = new Graph(50, 30, 10);
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
        g.printGraph();
        System.out.println();
    }

}
