package sort_03;
import java.util.Arrays;

public class cordRun01_StringArray05_quickSort {
	static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(String[] a, int start, int end) {
        swap(a, (start+end)/2, end);
        String value = a[end];                    // ���ذ�
        int i = start - 1;                     // i�� 1������ ������
        for (int j = start; j <= end - 1; ++j) // j�� 3������ ���� ����
            if (a[j].compareTo(value) < 0)          // a[j] ���� 1������ ���ϸ�
                swap(a, ++i, j);       // a[j] ���� 1������ ���� �߰��Ѵ�. 1���� ũ�� 1����.
        swap(a, i + 1, end);           // ���ذ��� a[end] ���ҿ� 2������ ���� ���Ҹ� ��ȯ�Ѵ�.
        return i + 1;                  // ���ذ� ��ġ ����
    }

    static void quickSort(String[] a, int start, int end) {
        if (start >= end) return;
        int middle = partition(a, start, end); // �迭 ������
        quickSort(a, start, middle-1);         // 1���� ����
        quickSort(a, middle+1, end);           // 2���� ����
    }
	
	public static void main(String[] args) {
		String[] starr= {"A", "Gear", "guitar", "love", "bear", "AA"};

		System.out.println(Arrays.toString(starr));

		quickSort(starr, 0, starr.length-1);

		System.out.println(Arrays.toString(starr));

		Arrays.sort(starr);

		System.out.println(Arrays.toString(starr));

	}
}
