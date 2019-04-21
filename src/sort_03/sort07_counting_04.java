package sort_03;
import java.util.Arrays;

public class sort07_counting_04 {
    // 성별로 정렬 (여자가 앞, 남자가 뒤)
    public static void countingSort(Person2[] a) {
        int 여자수 = 0;
        for (Person2 p : a) // 여자의 수를 센다
            if (p.getSex().equals("여자")) ++여자수;
        Person2[] r = new Person2[a.length];
        int 여자index = 0, 남자index = 여자수;
        for (Person2 p : a)
            if (p.getSex().equals("여자")) r[여자index++] = p;
            else r[남자index++] = p;
        for (int i = 0; i < a.length; ++i)
            a[i] = r[i];
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

        countingSort(a);
        System.out.println(Arrays.toString(a));
    }

}
