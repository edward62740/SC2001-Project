package hybrid_sort;

public class InsertionSort {
	
	public static long sort(int[] arr, int start, int end) {
		long cmp = 0;
		for (int i = start + 1; i <= end; i++) {
			for (int j = i; j > start; j--) {
				cmp++;
				if (arr[j] < arr[j - 1])
				{
	                int tmp = arr[j];
	                arr[j] = arr[j - 1];
	                arr[j - 1] = tmp;
				}
				else break;
			}
		}
		return cmp;
	}
}
