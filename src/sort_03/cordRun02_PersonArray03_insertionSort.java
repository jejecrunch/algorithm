package sort_03;
import java.util.Arrays;

public class cordRun02_PersonArray03_insertionSort {
	static PersonNameComparator comparator = new PersonNameComparator();
	
	static void insertionSort(Person[] a) {
        for (int i = 1; i < a.length; ++i) {
            Person value = a[i];             // ������ �� ����
            int j;
            for (j = i - 1; j >= 0; --j)  // �ڷ� �̵�
                if (comparator.compare(a[j], value) > 0)
                    a[j + 1] = a[j];
                else
                    break;
            a[j + 1] = value;             // �� ����
        }
    }
	
	public static void main(String[] args) {
		Person[] psarr= {new Person("�����", 32), new Person("�鿹��", 48), new Person("���", 27), new Person("����ȿ", 20), new Person("�ں���", 52), new Person("������", 72)};

		System.out.println(Arrays.toString(psarr));

		insertionSort(psarr);

		System.out.println(Arrays.toString(psarr));
	}

}
