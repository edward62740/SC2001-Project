package dp;

import java.util.ArrayList;

public class Knapsack {

	static int[][] A;

	static public int[][] run(int[] W, int[] P, int C) {
		A = new int[W.length+1][C+1];

		for (int i = 1; i <= W.length; i++) {
			for (int j = 1; j <= C; j++) {

				if (j < W[i-1])
					A[i][j] = A[i - 1][j];
				else
					A[i][j] = Math.max(A[i - 1][j], A[i - 1][j - W[i - 1]] + P[i-1]);

			}
		}
		return A;
	}


}
