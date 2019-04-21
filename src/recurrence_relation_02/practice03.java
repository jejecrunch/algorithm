package recurrence_relation_02;
import java.util.Scanner;

public class practice03 {
    static void print1(int n) {
    	for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i - 1; ++j)
                System.out.print(" ");
            for (int j = 0; j <= i ; ++j)
                System.out.print("*");
            System.out.println();
        }
    }

    static void print2(int n, int i, int j) {
    	if (i >= n) return; 
    	if(j < n-i-1) {
    		System.out.print(" ");
    	} else
    		System.out.print("*");
		if (j < n - 1) print2(n, i, j + 1); 
		else { 
			System.out.println(); 
			print2(n, i + 1, 0); 
		}
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("행 수를 입력하시오: ");
            int n = scanner.nextInt();
            print1(n);
            System.out.println();
            print2(n, 0, 0);
        }
    }

}
