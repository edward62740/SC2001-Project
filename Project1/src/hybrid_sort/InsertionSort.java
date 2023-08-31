package hybrid_sort;

public class InsertionSort {
	
	public static int sort(int[] arr, int start, int end) {
		int cmp = 0;
		for (int i = start + 1; i <= end; i++) {
			for (int j = i; j > 0; j--) {
				cmp++;
				if (arr[j] < arr[j - 1])
				{
					swap(arr, j, j - 1);
				}
				else break;
			}
		}
		return cmp;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
