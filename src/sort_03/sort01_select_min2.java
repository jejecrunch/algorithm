package sort_03;

public class sort01_select_min2 {
	// 배열 a의 start 위치부터 끝까지에서 가장 작은 값의 위치(index)를 리턴한다.
    static int findMin(int[] a, int start) {
    	int min=a[start];
    	int idx=start;
    	for(int i=start+1;i<a.length;i++) {
    		if(a[i]<min) {
    			min=a[i];
    			idx=i;
    		}
    	}
    	return idx;
    }

    public static void main(String[] args) {
        int[] a = { 14, 11, 13, 15 };

        for (int i = 0; i < a.length; ++i) {
            int minIndex = findMin(a, i);
            System.out.println(a[minIndex]);
        }
    }

}
