package dp;

public class Test {
	static public void main(String args[])
	{
		
		/* modify this */
		int capacity = 14;
		int[] W = { 4, 6, 7 };
	    int[] P = { 7, 6, 9 };
	    /***************/
	    
	    
		int ret[][] = Knapsack.run(W, P, capacity);
		
		for(int i=1; i<=W.length; i++)
		{
			for(int j=1; j<=capacity; j++)
			{
				System.out.print(ret[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Result: " + ret[W.length][capacity]);
	}
}
