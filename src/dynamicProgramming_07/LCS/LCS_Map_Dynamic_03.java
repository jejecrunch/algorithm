package dynamicProgramming_07.LCS;

import java.util.HashMap;
import java.util.Map;

public class LCS_Map_Dynamic_03 {
	static int LCS(String s1, String s2, Map<String,Integer> map) {
        if (s1.length() == 0 || s2.length() == 0) return 0;
        Integer value = map.get(s1 + s2);
        if (value != null) return value;
        System.out.printf("%s %s\n", s1, s2);

        if (s1.charAt(0) == s2.charAt(0)) {
            int r = 1 + LCS(s1.substring(1), s2.substring(1), map);
            map.put(s1 + s2, r);
            return r;
        }
        int lcs1 = LCS(s1, s2.substring(1), map);
        int lcs2 = LCS(s1.substring(1), s2, map);
        int r = Math.max(lcs1, lcs2);
        map.put(s1 + s2, r);
        return r;
    }

    static int LCS(String s1, String s2) {
        return LCS(s1, s2, new HashMap<String,Integer>());
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "123";
        System.out.println(LCS(s1, s2));
    }


}
