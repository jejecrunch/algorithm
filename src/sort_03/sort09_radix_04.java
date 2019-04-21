package sort_03;
import java.util.Arrays;

public class sort09_radix_04 {
	public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	
	// 0 ���� �������� partition. 1����:0 �̸� ��, 2����: 0 �̻� ��
    // 2������ ���� �ε����� ������
    public static int partitionBy0(int[] a) {
        int i = -1;
        for (int j = 0; j < a.length; ++j)
            if (a[j] < 0)
                swap(a, ++i, j);
        return i + 1;
    }

    // 256������ ǥ������ ��, nth �ڸ��� �������� �����Ѵ�.
    public static void countingSort(int[] a, int start, int end, int nth) {
        int[] count = new int[256]; // 256���� count�� �ʿ���.
        for (int i = start; i <= end; ++i) {
            int value = a[i];
            int digit = value >> (nth * 8) & 0xFF; // nth �ڸ��� ���� ����
            ++count[digit]; // digit �� count ����
        }
        // nth �ڸ��� ���� �������� ���� ���� ��, �� ���� ���� ��ġ ���
        int[] index = new int[256]; // ���� ��ġ �迭
        index[0] = 0;
        for (int i = 1; i < index.length; ++i)
            index[i] = index[i - 1] + count[i - 1];

        // ������ ����� ���� ��ġ�� ����Ͽ� ������ temp �迭�� ������. �� ������.
        int[] temp = new int[end - start + 1];
        for (int i = start; i <= end; ++i) {
            int value = a[i];
            int digit = value >> (nth * 8) & 0xFF;
            temp[index[digit]++] = value;
        }

        // ���ĵ� temp �迭�� ���� �Է� �迭�� ����
        for (int i = start; i <= end; ++i)
            a[i] = temp[i - start];
    }

    public static void radixSort(int[] a) {
    	int middle = partitionBy0(a); // ���� ��� �и�
        // 32bit�̹Ƿ�, 256���� 4�ڸ�
        for (int i = 0; i < 4; ++i) {
        	countingSort(a, 0, middle - 1, i);        // ���� ����
        	countingSort(a, middle, a.length - 1, i); // ��� ����
        }
    }

    public static void main(String[] args) {
        int[] a = { -1, 6, 2, -5, 1, 0, -2, 5, 3, -7, -3, 4, 7, -6, -4 };
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }

}
