package sort_03;
import java.util.Arrays;

public class cordRun03_EvenOddSort {
	
	static void swap(int[] a, int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	static void sort(int[] a) {
		int start=0;
		int end=a.length-1;
		while(true) {
			while(a[start]%2==0 && start < end)
				++start;
			while(a[end]%2==1 && start < end)
				--end;
			if(start>=end) break;
			swap(a, start, end);
		}
	}

	public static void main(String[] args) {
		int[] arr= {13, 9, -1, 0, 23, 16, 2};
		
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
