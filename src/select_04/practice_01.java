package select_04;
import java.util.Arrays;
import java.util.Random;

public class practice_01 {
	static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(int[] a, int start, int end, int pivotIndex) {
        swap(a, end, pivotIndex);
    	int value = a[end];                    // ���ذ�
        int i = start - 1;                     // i�� 1������ ������
        for (int j = start; j <= end - 1; ++j) // j�� 3������ ���� ����
            if (a[j] < value) {          // a[j] ���� 1������ ���ϸ�
                ++i;
            	if(i!=j) swap(a, ++i, j);       // a[j] ���� 1������ ���� �߰��Ѵ�. 1���� ũ�� 1����.
            }
        swap(a, i + 1, end);           // ���ذ��� a[end] ���ҿ� 2������ ���� ���Ҹ� ��ȯ�Ѵ�.
        return i + 1;                  // ���ذ� ��ġ ����
    }

    // a �迭�� start~end ���� nth ��° ���� ���� �����Ѵ�.
    static int select(int[] a, int start, int end, int nth) {
        if (start >= end) return a[start];     // ã�� �迭�� ũ�Ⱑ 1 �̸� ����
        int middle = partition(a, start, end, a[(a.length-1)/2]); // �迭 ������
        int middle_nth = middle - start + 1;   // middle ��ġ�� ���� start~end ���� middle_nth ��° ���� ��
        if (nth == middle_nth) return a[middle]; // ã������ ����
        if (nth < middle_nth)
            return select(a, start, middle-1, nth); // �� �κп��� ã�´�.
        else
            return select(a, middle+1, end, nth - middle_nth); //  �� �κп��� ã�´�.
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i)
            a[i] = random.nextInt(20);

        System.out.println(Arrays.toString(a));
        System.out.printf("1 ��° ���� �� = %d\n", select(a, 0, a.length-1, 1));
        System.out.printf("2 ��° ���� �� = %d\n", select(a, 0, a.length-1, 2));
        System.out.printf("3 ��° ���� �� = %d\n", select(a, 0, a.length-1, 3));
        System.out.printf("4 ��° ���� �� = %d\n", select(a, 0, a.length-1, 4));
    }

}
