package dynamicProgramming_07.PutStone;

public class practice_01 {
	static int[][] a = {
            {  6,  7, 12, -5, 5,  3, 11, 3 },
            { -8, 10, 14,  9, 7, 13,  8, 5 },
            { 11, 12,  7,  4, 8, -2,  9, 4 }};
	
	static int[][] sum=new int[8][5];

    static boolean ������������(int ����1, int ����2) {
        if (����1 == ����2) return false; // ������ ������ ������ �� ����.
        int[][] patterns = { {1, 4}, {3, 4}, {4, 1}, {4, 3} }; // ������ �� ���� ����
        for (int i = 0; i < patterns.length; ++i)
            if (����1 == patterns[i][0] && ����2 == patterns[i][1])
                return false;
        return true;
    }

    static int count=0;
    
    static int ��_����(int c, int p) throws Exception {
        switch (p) {
        case 1: return a[0][c]; // ����1
        case 2: return a[1][c]; // ����2
        case 3: return a[2][c]; // ����3
        case 4: return a[0][c] + a[2][c]; // ����4
        }
        throw new Exception("invalid p:" + p);
    }

    static int ��ü_����(int c, int p) throws Exception {
        if(sum[c][p]!=0) return sum[c][p];
        
        ++count;
        int ������_�ְ����� = Integer.MIN_VALUE;
        if(c==0) return sum[c][p]=��_����(c,p);
        for (int q = 1; q <= 4; ++q) // q�� c-1 ���� ����
            if (������������(p, q)) {
                int ���� = ��ü_����(c - 1, q);
                if (���� > ������_�ְ�����) ������_�ְ����� = ����;
            }
        return sum[c][p]=(������_�ְ����� + ��_����(c, p));
    }

    static int ��ü_����(int c) throws Exception {
        int �ְ����� = Integer.MIN_VALUE;
        for (int p = 1; p <= 4; ++p) {
            int ���� = ��ü_����(c, p);
            if (���� > �ְ�����) �ְ����� = ����;
        }
        return �ְ�����;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("������� "+��ü_����(7));
        System.out.println("ȣ��Ƚ�� " + count);
    }

}