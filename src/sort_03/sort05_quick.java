package sort_03;
import java.util.Arrays;
import java.util.Random;

public class sort05_quick {
	static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(int[] a, int start, int end) {
        swap(a, (start+end)/2, end);
        int value = a[end];                    // 기준값
        int i = start - 1;                     // i는 1구역의 끝지점
        for (int j = start; j <= end - 1; ++j) // j는 3구역의 시작 지점
            if (a[j] < value)          // a[j] 값이 1구역에 속하면
                swap(a, ++i, j);       // a[j] 값을 1구역의 끝에 추가한다. 1구역 크기 1증가.
        swap(a, i + 1, end);           // 기준값인 a[end] 원소와 2구역의 시작 원소를 교환한다.
        return i + 1;                  // 기준값 위치 리턴
    }

    static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        int middle = partition(a, start, end); // 배열 나누기
        quickSort(a, start, middle-1);         // 1구역 정렬
        quickSort(a, middle+1, end);           // 2구역 정렬
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i)
            a[i] = random.nextInt(20);

        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

}
