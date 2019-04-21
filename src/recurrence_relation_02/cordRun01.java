package recurrence_relation_02;
import java.util.Arrays;
import java.util.Random;

public class cordRun01 {
	static void print(int[] a, int index) {
        if (index >= a.length) return;
        System.out.printf("%d ", a[index]);
        print(a, index + 1);
    }

    static int sum(int[] a, int index) {
        if (index == a.length - 1) return a[index];
        return a[index] + sum(a, index + 1);
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i)
            a[i] = i;
        print(a, 0);
        System.out.println();
        System.out.println(sum(a,0));
    }

    // 0 1 2 3 4 5 6 7 8 9
    // 45
}
