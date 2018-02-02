public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        // 结果字符串的长度
        int resultLength = 0;
        // 结果字符串开始位置
        int resultStart = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            // 中心字符 为两个
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
            // 中心字符 为1个
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
        // 需加1，因为此时的开始位置，不包含第一个字符
        resultStart++;
        return s.substring(resultStart, resultStart + resultLength);
    }
}
