package sort_03;
import java.util.Arrays;

public class cordRun02_PersonArray05_quickSort {
	static PersonNameComparator comparator = new PersonNameComparator();
	
	static void swap(Person[] a, int i, int j) {
        Person temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(Person[] a, int start, int end) {
        swap(a, (start+end)/2, end);
        Person value = a[end];                    // ���ذ�
        int i = start - 1;                     // i�� 1������ ������
        for (int j = start; j <= end - 1; ++j) // j�� 3������ ���� ����
            if (comparator.compare(a[j], value) < 0)          // a[j] ���� 1������ ���ϸ�
                swap(a, ++i, j);       // a[j] ���� 1������ ���� �߰��Ѵ�. 1���� ũ�� 1����.
        swap(a, i + 1, end);           // ���ذ��� a[end] ���ҿ� 2������ ���� ���Ҹ� ��ȯ�Ѵ�.
        return i + 1;                  // ���ذ� ��ġ ����
    }

    static void quickSort(Person[] a, int start, int end) {
        if (start >= end) return;
        int middle = partition(a, start, end); // �迭 ������
        quickSort(a, start, middle-1);         // 1���� ����
        quickSort(a, middle+1, end);           // 2���� ����
    }
    
	public static void main(String[] args) {
		Person[] psarr= {new Person("�����", 32), new Person("�鿹��", 48), new Person("���", 27), new Person("����ȿ", 20), new Person("�ں���", 52), new Person("������", 72)};

		System.out.println(Arrays.toString(psarr));

		quickSort(psarr, 0, psarr.length-1);

		System.out.println(Arrays.toString(psarr));
	}

}
