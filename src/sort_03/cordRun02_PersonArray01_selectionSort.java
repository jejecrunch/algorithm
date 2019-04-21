package sort_03;
import java.util.Arrays;

public class cordRun02_PersonArray01_selectionSort {
	static PersonNameComparator comparator = new PersonNameComparator();
	
	// �迭 a���� i ��ġ�� j ��ġ�� ���� ���� �ٲ۴�
	static void swap(Person[] a, int i, int j) {
		Person temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	// �迭 a�� start ��ġ���� ���������� ���� ���� ���� ��ġ(index)�� �����Ѵ�.
	static int findMin(Person[] a, int start) {
		Person min=a[start];
		int idx=start;
		for(int i=start+1;i<a.length;i++) {
			if(comparator.compare(min, a[i]) > 0) {
				min=a[i];
				idx=i;
			}
		}
		return idx;
	}

	// selection sort
	static void selectionSort(Person[] a) {
		for (int i = 0; i < a.length - 1; ++i) {
			int minIndex = findMin(a, i); // �迭 a�� i ��ġ���� ���������� ���� ���� ���� ã�Ƽ�
			swap(a, i, minIndex);         // �� ���� i ��ġ�� �̵��Ѵ�
		}
	}

	public static void main(String[] args) {
		Person[] psarr= {new Person("�����", 32), new Person("�鿹��", 48), new Person("���", 27), new Person("����ȿ", 20), new Person("�ں���", 52), new Person("������", 72)};

		System.out.println(Arrays.toString(psarr));

		selectionSort(psarr);

		System.out.println(Arrays.toString(psarr));
	}

}
