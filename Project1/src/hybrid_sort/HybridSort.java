package hybrid_sort;

public class HybridSort {
	
	private int THRESHOLD = 0; // value of "S"
	
	public HybridSort(int th) {
		// TODO Auto-generated constructor stub
		this.THRESHOLD = th;
	}
	
	public int sort(int[] ar, int start, int end)
	{
		int cmp = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;

            cmp += sort(ar, start, mid);
            cmp += sort(ar, mid + 1, end);

            cmp += combine(ar, start, mid, end);
        }
        return cmp;
	}
	
	private int combine(int[] ar, int start, int mid, int end)
	{
		int cmp = 0;
		if(ar.length > THRESHOLD)
			cmp += MergeSort.merge(ar, start, end);
		else 
			cmp += InsertionSort.sort(ar, start, end);
		
		return cmp;
		
	}
}
