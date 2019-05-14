package dynamicProgramming_07.LCS;

public class LCS_Map_Dynamic_04 {
	static int LCS(String s1, String s2, Integer[][] a) {
        if (s1.length() == 0 || s2.length() == 0) return 0;
        Integer value = a[s1.length() - 1][s2.length() - 1];
        if (value != null) return value;

        if (s1.charAt(0) == s2.charAt(0)) {
            int r = 1 + LCS(s1.substring(1), s2.substring(1), a);
            a[s1.length() - 1][s2.length() - 1] = r;
            return r;
        }
        int lcs1 = LCS(s1, s2.substring(1), a);
        int lcs2 = LCS(s1.substring(1), s2, a);
        int r = Math.max(lcs1, lcs2);
        a[s1.length() - 1][s2.length() - 1] = r;
        return r;
    }

    static int LCS(String s1, String s2) {
        return LCS(s1, s2, new Integer[s1.length()][s2.length()]);
    }

    public static void main(String[] args) {
        String s1 = "abggcdefg";
        String s2 = "bbfcfdg";
        System.out.println(LCS(s1, s2));
    }
}
