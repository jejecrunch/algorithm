package sort_03;
import java.util.Arrays;

public class cordRun02_PersonArray02_bubbleSort {
	
	static PersonNameComparator comparator = new PersonNameComparator();
	
	// �迭 a���� i ��ġ�� j ��ġ�� ���� ���� �ٲ۴�
    static void swap(Person[] a, int i, int j) {
        Person temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // bubble sort
    static void bubbleSort(Person[] a) {
        for (int i = a.length - 1; i >= 1; --i) {
            boolean �Ϸ� = true;
            for (int j = 0; j < i; ++j) {
                if (comparator.compare(a[j], a[j+1]) > 0) {
                    swap(a, j, j + 1);
                    �Ϸ� = false;
                }
            }
            if (�Ϸ�) break;
        }
    }

	public static void main(String[] args) {
		Person[] psarr= {new Person("�����", 32), new Person("�鿹��", 48), new Person("���", 27), new Person("����ȿ", 20), new Person("�ں���", 52), new Person("������", 72)};

		System.out.println(Arrays.toString(psarr));

		bubbleSort(psarr);

		System.out.println(Arrays.toString(psarr));
	}

}
