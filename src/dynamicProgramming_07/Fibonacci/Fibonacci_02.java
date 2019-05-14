package dynamicProgramming_07.Fibonacci;

public class Fibonacci_02 {
	static int[] a = new int[100];

    /*static int fibonacci(int n) {
        System.out.printf("fibonacci(%d)\n", n);
        if (a[n] != 0) return a[n];
        if (n == 1 || n == 2) a[n] = 1;
        else a[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return a[n];
    }*/
	
	static int fibonacci(int n) {
        a[1] = a[2] = 1;
        for (int i = 3; i <= n; ++i)
            a[i] = a[i - 1] + a[i - 2];
        return a[n];
    }

	public static void main(String[] args) {
		int value = fibonacci(7);
		System.out.println(value);
	}

}
