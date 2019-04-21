package sort_03;
import java.util.Arrays;

public class cordRun01_StringArray02_bubbleSort {
	
	// 배열 a에서 i 위치와 j 위치의 값을 서로 바꾼다
    static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // bubble sort
    static void bubbleSort(String[] a) {
        for (int i = a.length - 1; i >= 1; --i) {
            boolean 완료 = true;
            for (int j = 0; j < i; ++j) {
                if (a[j].compareTo(a[j+1])>0) {
                    swap(a, j, j + 1);
                    완료 = false;
                }
            }
            if (완료) break;
        }
    }

	public static void main(String[] args) {
		String[] starr= {"A", "Gear", "guitar", "love", "bear", "AA"};

		System.out.println(Arrays.toString(starr));

		bubbleSort(starr);

		System.out.println(Arrays.toString(starr));

		Arrays.sort(starr);

		System.out.println(Arrays.toString(starr));

	}

}
