package sort_03;
import java.util.Arrays;

public class cordRun02_PersonArray02_bubbleSort {
	
	static PersonNameComparator comparator = new PersonNameComparator();
	
	// 배열 a에서 i 위치와 j 위치의 값을 서로 바꾼다
    static void swap(Person[] a, int i, int j) {
        Person temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // bubble sort
    static void bubbleSort(Person[] a) {
        for (int i = a.length - 1; i >= 1; --i) {
            boolean 완료 = true;
            for (int j = 0; j < i; ++j) {
                if (comparator.compare(a[j], a[j+1]) > 0) {
                    swap(a, j, j + 1);
                    완료 = false;
                }
            }
            if (완료) break;
        }
    }

	public static void main(String[] args) {
		Person[] psarr= {new Person("김민희", 32), new Person("백예린", 48), new Person("라온", 27), new Person("송지효", 20), new Person("박보영", 52), new Person("정유미", 72)};

		System.out.println(Arrays.toString(psarr));

		bubbleSort(psarr);

		System.out.println(Arrays.toString(psarr));
	}

}
