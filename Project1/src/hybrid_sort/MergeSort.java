package hybrid_sort;

import java.util.Arrays;

public class MergeSort {

	public static long sort(int[] ar, int start, int end) {
		long cmp = 0;
		if (start < end) {
			int mid = start + (end - start) / 2;

			cmp += sort(ar, start, mid);
			cmp += sort(ar, mid + 1, end);

			cmp += merge(ar, start, end, mid);
		}
		return cmp;
	}

	public static long merge(int[] ar, int start, int end, int mid) {
		 int n1 = mid - start + 1;
         int n2 = end - mid;
         int[] L = new int[n1];
         int[] R = new int[n2];
         long cmp = 0;

         for (int i = 0; i < n1; ++i)
             L[i] = ar[start + i];
         for (int j = 0; j < n2; ++j)
             R[j] = ar[mid + 1 + j];

         int i = 0, j = 0;
         int k = start;
         while (i < n1 && j < n2) {
        	 cmp++;
             if (L[i] <= R[j]) {
                 ar[k] = L[i];
                 i++;
             } else {
                 ar[k] = R[j];
                 j++;
             }
             k++;
         }
         while (i < n1) {
             ar[k] = L[i];
             i++;
             k++;
         }
         while (j < n2) {
             ar[k] = R[j];
             j++;
             k++;
         }
         return cmp;
     }

}
