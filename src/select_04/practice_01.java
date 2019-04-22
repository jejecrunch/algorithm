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

	static void quickSort(int[] a, int start, int end) {
		if (start >= end) return;
		int middle = partition(a, start, end, (start+end)/2); // �迭 ������
		quickSort(a, start, middle-1);         // 1���� ����
		quickSort(a, middle+1, end);           // 2���� ����
	}

	// a �迭�� start~end ���� nth ��° ���� ���� �����Ѵ�.
	static int select(int[] a, int start, int end, int nth) {
		if (start >= end) return a[start];     // ã�� �迭�� ũ�Ⱑ 1 �̸� ����
		int middle = partition(a, start, end, end); // �迭 ������
		int middle_nth = middle - start + 1;   // middle ��ġ�� ���� start~end ���� middle_nth ��° ���� ��
		if (nth == middle_nth) return a[middle]; // ã������ ����
		if (nth < middle_nth)
			return select(a, start, middle-1, nth); // �� �κп��� ã�´�.
		else
			return select(a, middle+1, end, nth - middle_nth); //  �� �κп��� ã�´�.
	}

	static int findIndex(int[] a, int start, int end, int value) {
		for(int i=start; i<=end; i++)
			if(a[i]==value) return i;
		return -1;
	}

	static int linearSelect(int[] a, int start, int end, int nth) {
		int size = end - start + 1;
		if(size<=5) {
			quickSort(a, start, end);
			return a[start+nth-1];
		} 
		int[] a1=new int[(size+4)/5];
		for(int i=0; i<a1.length; i++) {
			int start1 = start + i * 5;
			int end1 = Math.min(start1+4, end);
			quickSort(a, start1, end1);
			a1[i]=a[(start1+end1)/2];
		}
		int m = linearSelect(a1, 0, a1.length-1, a1.length/2);
		int mindex = findIndex(a, start, end, m);
		
		int middle=partition(a, start, end, mindex);
		int middle_nth = middle - start +1;
		if(nth == middle_nth) return a[middle];
		if(nth < middle_nth)
			return linearSelect(a, start, middle - 1, nth);
		else
			return linearSelect(a, middle_nth + 1, end, nth - middle_nth);

	}

	public static void main(String[] args) {
		Random random = new Random();
		int[] a = new int[23];
		for (int i = 0; i < a.length; ++i)
			a[i] = random.nextInt(100);

		for(int i=1;i<=5;++i) {
			int p = select(a, 0, a.length-1, i);
			int q = linearSelect(a, 0, a.length-1, i);
			System.out.printf("%d ��° ���� �� = %d %d\n", i, p, q);
		}

		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
