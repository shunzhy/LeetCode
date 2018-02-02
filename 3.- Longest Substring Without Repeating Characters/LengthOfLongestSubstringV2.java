public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        StringBuilder sb = new StringBuilder();
        String str;
        for (int i = 0; i < s.length(); i++) {
            str = s.charAt(i) + "";
            if (sb.indexOf(str) >= 0) {
                if (sb.length() > result) {
                    result = sb.length();
                }
                sb.delete(0, sb.indexOf(str) + 1);
                sb.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() > result) {
            result = sb.length();
        }
        return result;
    }
}
