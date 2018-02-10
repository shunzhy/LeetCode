public class LongestPalindrome {

    // 递归，超时！！！
    public static String longestPalindrome(String s) {
        if (checkPalindrme(s)) {
            return s;
        } else {
            String s1 = longestPalindrome(s.substring(0, s.length() - 1));
            String s2 = longestPalindrome(s.substring(1, s.length()));
            if (s1 != null && s2 != null) {
                return s1.length() > s2.length() ? s1 : s2;
            }
        }
        return null;
    }

    public static boolean checkPalindrme(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
