package sort_03;
import java.util.Map;
import java.util.TreeMap;

public class sort07_counting01 {
	public static void countingSort(char[] a) {
        Map<Character, Integer> counts = new TreeMap<>();
        for (char c : a) { // 각 문자의 수를 센다
            Integer i = counts.get(c);
            if (i == null) i = 0;
            counts.put(c, i + 1);
        }
        int index = 0; // 배열에 값을 채우기 위한 인덱스
        for (char c : counts.keySet()) { // 각 문자의 수 만큼 배열에 채운다
            for (int i = 0; i < counts.get(c); ++i)
                a[index++] = c;
        }
    }

    public static void main(String[] args) {
        char[] a = "hello world. good morning. how are you.".toCharArray();
        countingSort(a);
        System.out.printf("[%s]\n", new String(a));
    }

}
