package dp;

import java.util.ArrayList;

public class Knapsack {

	static int[][] A;

	static public int[][] run(int[] W, int[] P, int C) {
		A = new int[W.length][C];

		for (int i = 1; i < W.length; i++) {
			for (int j = 1; j < C; j++) {

				if (W[i] > j)
					A[i][j] = A[i - 1][j];
				else
					A[i][j] = max(A[i - 1][j], A[i - 1][j - W[i - 1]] + P[i]);

			}
		}
		return A;
	}

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if (i > j)
			return i;
		else
			return j;
	}

}
