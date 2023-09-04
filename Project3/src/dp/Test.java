package dp;

public class Test {
	static public void main(String args[])
	{
		
		

		int[] W = { 5, 6, 8 };
	    int[] P = { 7, 6, 9 };
		int ret[][] = Knapsack.run(W, P, 14);
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<14; j++)
			{
				System.out.print(ret[i][j] + " ");
			}
			System.out.println();
		}
	}
}
