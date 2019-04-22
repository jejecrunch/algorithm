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
		int value = a[end];                    // 기준값
		int i = start - 1;                     // i는 1구역의 끝지점
		for (int j = start; j <= end - 1; ++j) // j는 3구역의 시작 지점
			if (a[j] < value) {          // a[j] 값이 1구역에 속하면
				++i;
				if(i!=j) swap(a, ++i, j);       // a[j] 값을 1구역의 끝에 추가한다. 1구역 크기 1증가.
			}
		swap(a, i + 1, end);           // 기준값인 a[end] 원소와 2구역의 시작 원소를 교환한다.
		return i + 1;                  // 기준값 위치 리턴
	}

	static void quickSort(int[] a, int start, int end) {
		if (start >= end) return;
		int middle = partition(a, start, end, (start+end)/2); // 배열 나누기
		quickSort(a, start, middle-1);         // 1구역 정렬
		quickSort(a, middle+1, end);           // 2구역 정렬
	}

	// a 배열의 start~end 에서 nth 번째 작은 값을 리턴한다.
	static int select(int[] a, int start, int end, int nth) {
		if (start >= end) return a[start];     // 찾을 배열의 크기가 1 이면 리턴
		int middle = partition(a, start, end, end); // 배열 나누기
		int middle_nth = middle - start + 1;   // middle 위치의 값이 start~end 에서 middle_nth 번째 작은 값
		if (nth == middle_nth) return a[middle]; // 찾았으면 리턴
		if (nth < middle_nth)
			return select(a, start, middle-1, nth); // 앞 부분에서 찾는다.
		else
			return select(a, middle+1, end, nth - middle_nth); //  뒷 부분에서 찾는다.
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
			System.out.printf("%d 번째 작은 값 = %d %d\n", i, p, q);
		}

		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
