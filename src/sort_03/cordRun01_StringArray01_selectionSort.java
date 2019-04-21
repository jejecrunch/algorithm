package sort_03;
import java.util.Arrays;

public class cordRun01_StringArray01_selectionSort {
	
	// �迭 a���� i ��ġ�� j ��ġ�� ���� ���� �ٲ۴�
    static void swap(String[] a, int i, int j) {
    	String temp=a[i];
    	a[i]=a[j];
    	a[j]=temp;
    }
	
	// �迭 a�� start ��ġ���� ���������� ���� ���� ���� ��ġ(index)�� �����Ѵ�.
	static int findMin(String[] a, int start) {
		String min = a[start];
		int idx = start;
		for(int i=start+1;i<a.length;i++) {
			if(a[i].compareTo(min)<0) {
				min=a[i];
				idx=i;
			}
		}
		return idx;
	}
	
	 // selection sort
    static void selectionSort(String[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            int minIndex = findMin(a, i); // �迭 a�� i ��ġ���� ���������� ���� ���� ���� ã�Ƽ�
            swap(a, i, minIndex);         // �� ���� i ��ġ�� �̵��Ѵ�
        }
    }

	public static void main(String[] args) {
		String[] starr= {"A", "Gear", "guitar", "love", "bear", "AA"};

		System.out.println(Arrays.toString(starr));

		selectionSort(starr);

		System.out.println(Arrays.toString(starr));

		Arrays.sort(starr);

		System.out.println(Arrays.toString(starr));

	}

}
