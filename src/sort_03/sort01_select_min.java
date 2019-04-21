package sort_03;

public class sort01_select_min {
	// 배열 a에서 가장 작은 값의 위치(index)를 리턴한다.
    static int findMin(int[] a) {
     	int idx=0;
       	int min=0;
    	for(int i=1;i<a.length;i++) {
    		min=a[idx];
    		if(a[i]<min) {
    			idx=i;
    		}
    	}
    	return idx;
    }

    public static void main(String[] args) {
        int[] a1 = { 17, 14, 11, 19 };
        int[] a2 = { -17, -14, -11, -19 };

        int minIndex = findMin(a1);
        System.out.println(a1[minIndex]);

        minIndex = findMin(a2);
        System.out.println(a2[minIndex]);
    }

}
