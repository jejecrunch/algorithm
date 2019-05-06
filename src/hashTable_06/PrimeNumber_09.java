package hashTable_06;

import java.util.Arrays;

public class PrimeNumber_09 {
	
	private static int getStepDistance(int value) {
	    int r = 0;
	    switch (value % 7) {
	    case 0: r = 3; break;
	    case 1: r = 5; break;
	    case 2: r = 7; break;
	    case 3: r = 11; break;
	    case 4: r = 13; break;
	    case 5: r = 17; break;
	    case 6: r = 19; break;
	    }
	    return r;
	}

	public static void main(String[] args) {
        int hashTableSize = 13;
        int step = 4;
        int startIndex = 3;
        int[] a = new int[hashTableSize];

        for (int i = 0; i < hashTableSize; ++i) {
            int index = (startIndex + (step * i)) % hashTableSize;
            a[i] = index;
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
