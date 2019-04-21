package sort_03;
import java.util.Map;
import java.util.TreeMap;

public class sort07_counting01 {
	public static void countingSort(char[] a) {
        Map<Character, Integer> counts = new TreeMap<>();
        for (char c : a) { // �� ������ ���� ����
            Integer i = counts.get(c);
            if (i == null) i = 0;
            counts.put(c, i + 1);
        }
        int index = 0; // �迭�� ���� ä��� ���� �ε���
        for (char c : counts.keySet()) { // �� ������ �� ��ŭ �迭�� ä���
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
