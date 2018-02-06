public class IsPalindrome {
    public boolean isPalindrome(int x) {
        String s = x + "";
        int start = 0;
        int end = s.length() - 1;
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}
