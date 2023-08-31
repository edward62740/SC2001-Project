package hybrid_sort;

import java.util.Random;

public class Test {
	
	private static final long SEED = 1234L;
	
	public static void main(String args[])
	{
		int arrSize = 1000;
		HybridSort sorter = new HybridSort(111);
		long start, stop;
		int ret;
		for(int i=1; i<5; i++) // array size to 10M
		{
			arrSize *= 10;
			System.out.println(arrSize);
			int[] randomArray = generateArray(arrSize);
			start = System.currentTimeMillis();
			ret = sorter.sort(randomArray, 0, randomArray.length-1);
			stop = System.currentTimeMillis();
			
			System.out.println("Time taken: " + (stop-start) + " ms for " + arrSize + " iterations and " +
			ret + " key comparisons");
			randomArray = null;
		}
	}
	
	
    public static int[] generateArray(int length) {
    	int[] array = new int[length];
        Random random = new Random();
        random.setSeed(SEED);

        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000);
        }

        return array;
    }
}
