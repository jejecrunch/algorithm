package sort_03;
import java.util.Arrays;

public class cordRun01_StringArray01_selectionSort {
	
	// 배열 a에서 i 위치와 j 위치의 값을 서로 바꾼다
    static void swap(String[] a, int i, int j) {
    	String temp=a[i];
    	a[i]=a[j];
    	a[j]=temp;
    }
	
	// 배열 a의 start 위치부터 끝까지에서 가장 작은 값의 위치(index)를 리턴한다.
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
            int minIndex = findMin(a, i); // 배열 a의 i 위치부터 끝까지에서 가장 작은 값을 찾아서
            swap(a, i, minIndex);         // 그 값을 i 위치로 이동한다
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
