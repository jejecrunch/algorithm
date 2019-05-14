package dynamicProgramming_07.LCS;

public class LCS_01 {
	static int LCS(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) return 0;
        if (s1.charAt(0) == s2.charAt(0))
            return 1 + LCS(s1.substring(1), s2.substring(1));
        int lcs1 = LCS(s1, s2.substring(1));
        int lcs2 = LCS(s1.substring(1), s2);
        return Math.max(lcs1, lcs2);
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "adbc";
        System.out.println(LCS(s1, s2));
    }

}
