package sort_03;
import java.util.Arrays;

public class sort07_counting_04 {
    // ������ ���� (���ڰ� ��, ���ڰ� ��)
    public static void countingSort(Person2[] a) {
        int ���ڼ� = 0;
        for (Person2 p : a) // ������ ���� ����
            if (p.getSex().equals("����")) ++���ڼ�;
        Person2[] r = new Person2[a.length];
        int ����index = 0, ����index = ���ڼ�;
        for (Person2 p : a)
            if (p.getSex().equals("����")) r[����index++] = p;
            else r[����index++] = p;
        for (int i = 0; i < a.length; ++i)
            a[i] = r[i];
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

        countingSort(a);
        System.out.println(Arrays.toString(a));
    }

}
