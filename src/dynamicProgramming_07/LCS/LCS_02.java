package dynamicProgramming_07.LCS;

public class LCS_02 {
	static String LCS(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) return "";
        System.out.printf("%s %s\n", s1, s2); // 중복호출 확인
        if (s1.charAt(0) == s2.charAt(0))
            return s1.charAt(0) + LCS(s1.substring(1), s2.substring(1));
        String lcs1 = LCS(s1, s2.substring(1));
        String lcs2 = LCS(s1.substring(1), s2);
        return lcs1.length() > lcs2.length() ? lcs1 : lcs2;
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "adbc";
        System.out.println(LCS(s1, s2));
    }

}
