package sort_03;
import java.util.Arrays;

public class sort01_select_swap {
	// �迭 a���� i ��ġ�� j ��ġ�� ���� ���� �ٲ۴�
    static void swap(int[] a, int i, int j) {
    	int temp = a[i];
    	a[i]=a[j];
    	a[j]=temp;
    }

    public static void main(String[] args) {
        int[] a = { 2, 4 };

        System.out.println(Arrays.toString(a));
        swap(a, 0, 1);
        System.out.println(Arrays.toString(a));
    }

}
