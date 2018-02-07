public class IsMatch {
    /**
     第二个版本，思路是将s与p转化成最简式，即将相同字符转化成*
     完全无法解决问题，因为s 要完全与 p相等，且*号代表>=0，这边等于0的情况亦无法解决
     废弃。
    */
    public static boolean isMatch(String s, String p) {
        if (".*".equals(p)) {
            return true;
        }

        s = conver(s);
        p = conver(p);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '.') {

                return false;
            }
        }

        return true;
    }

    public static String conver(String s) {
        char c1 = 0;
        boolean asterisk = false;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == c1) {
                if (!asterisk) {
                    asterisk = true;
                    sb.append("*");
                }
            } else {
                c1 = c;
                sb.append(c);
                asterisk = false;
            }
        }
        return sb.toString();
    }
}
