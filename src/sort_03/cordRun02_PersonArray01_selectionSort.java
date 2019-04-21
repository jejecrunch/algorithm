package sort_03;
import java.util.Arrays;

public class cordRun02_PersonArray01_selectionSort {
	static PersonNameComparator comparator = new PersonNameComparator();
	
	// 배열 a에서 i 위치와 j 위치의 값을 서로 바꾼다
	static void swap(Person[] a, int i, int j) {
		Person temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	// 배열 a의 start 위치부터 끝까지에서 가장 작은 값의 위치(index)를 리턴한다.
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
			int minIndex = findMin(a, i); // 배열 a의 i 위치부터 끝까지에서 가장 작은 값을 찾아서
			swap(a, i, minIndex);         // 그 값을 i 위치로 이동한다
		}
	}

	public static void main(String[] args) {
		Person[] psarr= {new Person("김민희", 32), new Person("백예린", 48), new Person("라온", 27), new Person("송지효", 20), new Person("박보영", 52), new Person("정유미", 72)};

		System.out.println(Arrays.toString(psarr));

		selectionSort(psarr);

		System.out.println(Arrays.toString(psarr));
	}

}
