package hybrid_sort;

import java.util.Arrays;

public class MergeSort {

	public static int sort(int[] ar, int start, int end) {
		int cmp = 0;
		if (start < end) {
			int mid = start + (end - start) / 2;

			cmp += sort(ar, start, mid);
			cmp += sort(ar, mid + 1, end);

			cmp += merge(ar, start, end);
		}
		return cmp;
	}

	public static int merge(int[] ar, int start, int end) {
		int mid = start + (end - start) / 2;
		 int n1 = mid - start + 1;
         int n2 = end - mid;
         int[] L = new int[n1];
         int[] R = new int[n2];
         int cmp = 0;

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
