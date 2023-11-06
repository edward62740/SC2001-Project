package dp;

import java.util.ArrayList;

public class Knapsack {

	static int[] A;

	static public int[] run(int[] W, int[] P, int C) {
		A = new int[C+1];
        for (int i = 0; i < W.length; i++) {
            for (int j = 1; j <= C; j++) {
                if (W[i] <= j) {
                    A[j] = Math.max(A[j], P[i] + A[j - W[i]]);
                }
            }
        }
		return A;
	}


}
