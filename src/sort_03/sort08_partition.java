package sort_03;
import java.util.Arrays;

public class sort08_partition {
	public static void swap(Person2[] a, int i, int j) {
        Person2 temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // �迭�� �и� (���ڰ� ��, ���ڰ� ��)
    public static void partition(Person2[] a) {
        int i = -1; // 1����, �� ���� ������ ��
        for (int j = 0; j < a.length; ++j)
            if (a[j].getSex().equals("����"))
                swap(a, ++i, j);
    }

    public static void main(String[] args) {
        Person2[] a = { new Person2("ȫ�浿", "����", "O"),
                new Person2("����ġ", "����", "A"),
                new Person2("������", "����", "AB"),
                new Person2("�̸���", "����", "D"),
                new Person2("��û", "����", "O"),
                new Person2("�Ӳ���", "����", "A"),
                new Person2("����", "����", "AB")
        };

        partition(a);
        System.out.println(Arrays.toString(a));
    }

}
