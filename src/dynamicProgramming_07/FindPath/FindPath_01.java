package dynamicProgramming_07.FindPath;

public class FindPath_01 {

	static int[][] a = { { 6,  7, 12,  5 },
			{ 5,  3, 11, 18 },
			{ 7, 17,  3,  3 },
			{ 8, 10, 14,  9 } };
	
	static int[][] sum = new int[4][4];

	static int ����(int r, int c) {
		System.out.printf("����(%d, %d) ", r, c);
        if (sum[r][c] != 0) return sum[r][c];
        int �����ܰ����� = 0;
        if (r == 0 && c == 0) �����ܰ����� = 0;
        else if (r == 0) �����ܰ����� = ����(r, c-1);
        else if (c == 0) �����ܰ����� = ����(r - 1, c);
        else �����ܰ����� = Math.min(����(r, c - 1), ����(r - 1, c));
        sum[r][c] = �����ܰ����� + a[r][c];
        return sum[r][c];

	}

	public static void main(String[] args) {
		System.out.println(����(3,3));
	}

}
