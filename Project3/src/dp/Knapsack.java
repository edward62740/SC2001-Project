package dp;

import java.util.ArrayList;

public class Knapsack {

	static int[] A;

	static public int[] run(int[] W, int[] P, int C) {
		A = new int[C + 1];
		for (int i = 0; i <= C; i++) {
			for (int j = 0; j < W.length; j++) {
				if (W[j] <= i) {
					A[i] = Math.max(A[i], P[j] + A[i - W[j]]);

				}
			}
		}
		return A;
	}

}
