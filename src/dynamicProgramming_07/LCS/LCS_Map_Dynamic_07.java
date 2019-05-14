package dynamicProgramming_07.LCS;

public class LCS_Map_Dynamic_07 {
	static String LCS(String s1, int start1, String s2, int start2, String[][] a) {
        if (start1 >= s1.length() || start2 >= s2.length()) return "";
        String value = a[start1][start2];
        if (value != null) return value;
        if (s1.charAt(start1) == s2.charAt(start2)) {
            String r = s1.charAt(start1) + LCS(s1, start1 + 1, s2, start2 + 1, a);
            a[start1][start2] = r;
            return r;
        }
        String lcs1 = LCS(s1, start1, s2, start2 + 1, a);
        String lcs2 = LCS(s1, start1 + 1, s2, start2, a);
        String r = lcs1.length() > lcs2.length() ? lcs1 : lcs2;
        a[start1][start2] = r;
        return r;
    }

    static String LCS(String s1, String s2) {
        return LCS(s1, 0, s2, 0, new String[s1.length()][s2.length()]);
    }

    public static void main(String[] args) {
        String s1 = "abggcdefg";
        String s2 = "bbfcfdg";
        System.out.println(LCS(s1, s2));
    }
}
