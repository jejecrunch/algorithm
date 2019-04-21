package sort_03;
import java.util.Arrays;
import java.util.Random;

public class cordRun07_quickSort_middle_start_partition {
	static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(int[] a, int start, int end) {
        swap(a, (start+end)/2, start);
        int value = a[start];                    // ���ذ��� ���ΰ����� �ϰ� �� �κ� ���� 1����, 2����, 3�������� ����
        int i = end + 1;                     // i�� 1������ ������
        for (int j = end; j >= start + 1; --j) // j�� 3������ ���� ����
            if (a[j] > value)          // a[j] ���� 1������ ���ϸ�
                swap(a, --i, j);       // a[j] ���� 1������ ���� �߰��Ѵ�. 1���� ũ�� 1����.
        swap(a, i - 1, start);           // ���ذ��� a[end] ���ҿ� 2������ ���� ���Ҹ� ��ȯ�Ѵ�.
        return i - 1;                  // ���ذ� ��ġ ����
    }

    static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        int middle = partition(a, start, end); // �迭 ������
        quickSort(a, start, middle-1);         // 1���� ����
        quickSort(a, middle+1, end);           // 2���� ����
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i)
            a[i] = random.nextInt(20);

        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}