package dynamicProgramming_07.LCS;

public class LCS_Map_Dynamic_05 {
	static String LCS(String s1, String s2, String[][] a) {
        final int N1 = s1.length(), N2 = s2.length();
        if (N1 == 0 || N2 == 0) return "";
        String value = a[N1 - 1][N2 - 1];
        if (value != null) return value;
        if (s1.charAt(0) == s2.charAt(0)) {
            String r = s1.charAt(0) + LCS(s1.substring(1), s2.substring(1), a);
            a[N1 - 1][N2 - 1] = r;
            return r;
        }
        String lcs1 = LCS(s1, s2.substring(1), a);
        String lcs2 = LCS(s1.substring(1), s2, a);
        String r = lcs1.length() > lcs2.length() ? lcs1 : lcs2;
        a[N1 - 1][N2 - 1] = r;
        return r;
    }

    static String LCS(String s1, String s2) {
        return LCS(s1, s2, new String[s1.length()][s2.length()]);
    }

    public static void main(String[] args) {
        String s1 = "abggcdefg";
        String s2 = "bbfcfdg";
        System.out.println(LCS(s1, s2));
    }
}
