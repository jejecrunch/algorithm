package sort_03;
import java.util.Arrays;

public class cordRun01_StringArray03_insertionSort {

	static void insertionSort(String[] a) {
        for (int i = 1; i < a.length; ++i) {
            String value = a[i];             // ������ �� ����
            int j;
            for (j = i - 1; j >= 0; --j)  // �ڷ� �̵�
                if (a[j].compareTo(value) > 0)
                    a[j + 1] = a[j];
                else
                    break;
            a[j + 1] = value;             // �� ����
        }
    }
	
	public static void main(String[] args) {
		String[] starr= {"A", "Gear", "guitar", "love", "bear", "AA"};

		System.out.println(Arrays.toString(starr));

		insertionSort(starr);

		System.out.println(Arrays.toString(starr));

		Arrays.sort(starr);

		System.out.println(Arrays.toString(starr));

	}

}
