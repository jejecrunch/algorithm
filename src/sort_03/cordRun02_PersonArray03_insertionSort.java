package sort_03;
import java.util.Arrays;

public class cordRun02_PersonArray03_insertionSort {
	static PersonNameComparator comparator = new PersonNameComparator();
	
	static void insertionSort(Person[] a) {
        for (int i = 1; i < a.length; ++i) {
            Person value = a[i];             // 삽입할 값 보관
            int j;
            for (j = i - 1; j >= 0; --j)  // 뒤로 이동
                if (comparator.compare(a[j], value) > 0)
                    a[j + 1] = a[j];
                else
                    break;
            a[j + 1] = value;             // 값 삽입
        }
    }
	
	public static void main(String[] args) {
		Person[] psarr= {new Person("김민희", 32), new Person("백예린", 48), new Person("라온", 27), new Person("송지효", 20), new Person("박보영", 52), new Person("정유미", 72)};

		System.out.println(Arrays.toString(psarr));

		insertionSort(psarr);

		System.out.println(Arrays.toString(psarr));
	}

}
