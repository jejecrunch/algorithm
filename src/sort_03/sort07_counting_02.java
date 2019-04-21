package sort_03;

public class sort07_counting_02 {
    // 배열에 영어 알파벳 소문자만 들어있다고 가정한 경우
	public static void countingSort(char[] a) {
        int[] counts = new int['z' - 'a' + 1];
        for (char c : a) // 각 문자의 수를 센다
            ++counts[c - 'a'];
        int index = 0; // 배열에 값을 채우기 위한 인덱스
        for (int i = 0; i < counts.length; ++i) // 각 문자의 수 만큼 배열에 채운다
            for (int j = 0; j < counts[i]; ++j)
                a[index++] = (char)('a' + i);
    }

    public static void main(String[] args) {
        char[] a = "helloworldgoodmorninghowareyou".toCharArray();
        countingSort(a);
        System.out.printf("[%s]\n", new String(a));
    }
}
