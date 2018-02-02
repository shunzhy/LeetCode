public class LongestPalindrome {

    public static String longestPalindrome(String s) {

        int resultLength = 0;
        int resultStart = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            int start = i;
            int end = i + 1;
            int length = 0;
            while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
                length += 2;
            }
            if (length > resultLength) {
                resultLength = length;
                resultStart = start;
            }
            start = i - 1;
            end = i + 1;
            length = 1;
            while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
                length += 2;
            }
            if (length > resultLength) {
                resultLength = length;
                resultStart = start;
            }
        }
        resultStart++;
        return s.substring(resultStart, resultStart + resultLength);
    }
}
