package sort_03;
import java.util.Arrays;

public class sort09_radix_02 {
	public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 256������ ǥ������ ��, nth �ڸ��� �������� �����Ѵ�.
    public static void countingSort(int[] a, int nth) {
        int[] count = new int[256]; // 256���� count�� �ʿ���.
        for (int value : a) {
            int digit = value >> (nth * 8) & 0xFF; // nth �ڸ��� ���� ����
            ++count[digit]; // digit �� count ����
        }
        // nth �ڸ��� ���� �������� ���� ���� ��, �� ���� ���� ��ġ ���
        int[] index = new int[256]; // ���� ��ġ �迭
        index[0] = 0;
        for (int i = 1; i < index.length; ++i)
            index[i] = index[i - 1] + count[i - 1];

        // ������ ����� ���� ��ġ�� ����Ͽ� ������ temp �迭�� ������. �� ������.
        int[] temp = new int[a.length];
        for (int value : a) {
            int digit = value >> (nth * 8) & 0xFF;
            temp[index[digit]++] = value;
        }

        // ���ĵ� temp �迭�� ���� �Է� �迭�� ����
        for (int i = 0; i < a.length; ++i)
            a[i] = temp[i];
    }

    public static void radixSort(int[] a) {
        // 32bit�̹Ƿ�, 256���� 4�ڸ�
        for (int i = 0; i < 4; ++i)
            countingSort(a, i);
    }

    public static void main(String[] args) {
        int[] a = { 8, 6, 2, 9, 1, 0, 10, 5, 3, 11, 12, 4, 7, 13, 14 };
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }

}
