package dynamanicProgramming_07.matrix;

import java.util.Arrays;

public class CompareObjectArray_01 {
    static class Data {
        int i;

        public Data(int i) {
            this.i = i;
        }
    }

    public static void main(String[] args) {
        Data[] a1 = {new Data(1), new Data(2), new Data(3)};
        Data[] a2 = {new Data(1), new Data(2), new Data(3)};

        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));
        System.out.println(Arrays.equals(a1, a2));
    }

}
