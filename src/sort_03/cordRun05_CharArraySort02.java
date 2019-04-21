package sort_03;
import java.util.Arrays;

public class cordRun05_CharArraySort02 {
	static void sort(char[] a) {
		for(int i=0;i<a.length-1;i++) {
			for(int j=i;j<a.length;j++) {
				if(a[i]>a[j]) {
					char temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		char[] starr= {'c','v','u','q','p','j','l'};
		
		System.out.println(Arrays.toString(starr));
		
		sort(starr);
		
		System.out.println(Arrays.toString(starr));
		
		Arrays.sort(starr);
		
		System.out.println(Arrays.toString(starr));
	}
}
