package sort_03;
import java.util.Arrays;

public class sort08_partition {
	public static void swap(Person2[] a, int i, int j) {
        Person2 temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 배열을 분리 (여자가 앞, 남자가 뒤)
    public static void partition(Person2[] a) {
        int i = -1; // 1구역, 즉 여자 구역의 끝
        for (int j = 0; j < a.length; ++j)
            if (a[j].getSex().equals("여자"))
                swap(a, ++i, j);
    }

    public static void main(String[] args) {
        Person2[] a = { new Person2("홍길동", "남자", "O"),
                new Person2("전우치", "남자", "A"),
                new Person2("성춘향", "여자", "AB"),
                new Person2("이몽룡", "남자", "D"),
                new Person2("심청", "여자", "O"),
                new Person2("임꺽정", "남자", "A"),
                new Person2("장길산", "남자", "AB")
        };

        partition(a);
        System.out.println(Arrays.toString(a));
    }

}
