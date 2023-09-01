package hybrid_sort;

public class HybridSort {
	
	static private int THRESHOLD = 0; // value of "S"
	
	static public void setThreshold(int th)
	{
		THRESHOLD = th;
	}
	
	static public long sort(int[] ar, int start, int end)
	{
		long cmp = 0;
        if (start < end) {
    		if((end-start) <= THRESHOLD)
    			cmp += InsertionSort.sort(ar, start, end);
    		else 
    		{
    			int mid = (start+end)/2;
    			cmp += sort(ar, start, mid);
    			cmp += sort(ar, mid+1, end);
    			cmp += MergeSort.merge(ar, start, end, mid);
    		}
        }
        return cmp;
	}
}
