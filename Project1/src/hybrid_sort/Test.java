package hybrid_sort;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {

	private static final long SEED = 1234L;

	public static void main(String args[]) {
        int arrSize = 10000000;
        HybridSort.setThreshold(64);
        long start1, stop1;
        long start2, stop2;
        long ret1, ret2;
        
        try {
            FileWriter csvWriter = new FileWriter("sort_times.csv");
            csvWriter.append("size,time(ms)(hybrid),time(ms)(merge),cmp(hybrid),cmp(merge)\n"); // Header for CSV file
            
            Boolean isSorted = true;
            System.out.println(arrSize);
            int[] randomArray = generateArray(arrSize);
            start1 = System.currentTimeMillis();
            ret1 = HybridSort.sort(randomArray, 0, randomArray.length - 1);
            stop1 = System.currentTimeMillis();
            /* verify sorted order */
            for (int j = 1; j < randomArray.length; j++)
                if (randomArray[j - 1] > randomArray[j])
                    isSorted = false;
            System.out.println("Hybrid Sorted: " + isSorted + ". Time taken: " + (stop1 - start1) + " ms for " + arrSize + " arrsize and " +
                    ret1 + " key comparisons");
            isSorted = true;
            randomArray = generateArray(arrSize);
            start2 = System.currentTimeMillis();
            ret2 = MergeSort.sort(randomArray, 0, randomArray.length - 1);
            stop2 = System.currentTimeMillis();
            /* verify sorted order */
            for (int j = 1; j < randomArray.length; j++)
                if (randomArray[j - 1] > randomArray[j])
                    isSorted = false;

            System.out.println("Merge Sorted: " + isSorted + ". Time taken: " + (stop2 - start2) + " ms for " + arrSize + " arrsize and " +
                    ret2 + " key comparisons");

            // Append data to the CSV file
            csvWriter.append(arrSize + "," + (stop1 - start1) + "," + (stop2 - start2) + "," + ret1 + "," + ret2 + "\n");

            randomArray = null;
        
            
            csvWriter.close(); // Close the CSV file writer
        } catch (IOException e) {
            e.printStackTrace();
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
