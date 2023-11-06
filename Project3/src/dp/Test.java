package dp;

public class Test {
	static public void main(String args[])
	{
		
		/* modify this */
		int capacity = 14;
		int[] W = { 4, 6, 8 };
	    int[] P = { 7, 6, 9 };
	    /***************/
	    
	    
		int ret[] = Knapsack.run(W, P, capacity);
		System.out.println("Result: " + ret[capacity]);
	}
}
