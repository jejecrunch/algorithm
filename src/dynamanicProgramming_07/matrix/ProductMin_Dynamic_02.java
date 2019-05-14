package dynamanicProgramming_07.matrix;

public class ProductMin_Dynamic_02 {
	static class Matrix {
        int row, col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[][] �ּҰ�����;

    static int ����Ƚ���ּҰ�(Matrix[] a) {
        �ּҰ����� = new int[a.length][a.length];
        for (int distance = 1; distance < a.length; ++distance)
        for (int start = 0; start < a.length - distance; ++start) {
            int end = start + distance;
            �ּҰ�����[start][end] = Integer.MAX_VALUE;
            for (int middle = start; middle < end; ++middle) {
                int Ƚ�� = �ּҰ�����[start][middle];
                Ƚ�� += �ּҰ�����[middle + 1][end];
                Ƚ�� += a[start].row * a[middle].col * a[end].col;
                if (Ƚ�� < �ּҰ�����[start][end]) �ּҰ�����[start][end] = Ƚ��;
            }
        }
        return �ּҰ�����[0][a.length-1];
    }

    public static void main(String[] args) {
        Matrix[] a = new Matrix[] { new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50),
                                    new Matrix(50, 3), new Matrix(3, 8), new Matrix(8, 30) };
        System.out.println(����Ƚ���ּҰ�(a));
    }
}
