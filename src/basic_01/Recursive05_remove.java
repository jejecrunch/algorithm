package basic_01;

public class Recursive05_remove {
	static void print(int[] a) {
		for(int i : a)
			System.out.printf("%d ", i);
	}
	
	static void remove(int[] a, int index) {
		if(index>=a.length-1) return; // 재귀호출 종료 조건 구현
		a[index]=a[index+1]; // 현재 단계 작업
		remove(a, index + 1); // 다음 단계 작업 재귀호출
	}
	
	public static void main(String[] args) {
		int[] a = new int[10];
		for(int i=0;i<a.length;++i)
			a[i]=i;
		
		remove(a,5);
		
		a[a.length-1]=0;
		
		print(a);
	}
}
