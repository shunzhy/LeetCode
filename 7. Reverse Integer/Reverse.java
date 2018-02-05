public class Reverse {
    public int reverse(int x) {
        String s = x + "";
        // 负数判断
        boolean negativeFlag = false;
        if (x < 0) {
            negativeFlag = true;
            s = s.replace("-", "");
        }
        // 反转
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        while(s.length() > 0 && s.charAt(0) == '0') {
            s = s.substring(1, s.length());
        }
        if (!Objects.equals(s, "")) {
            // 溢出判断
            if (Long.valueOf(s) > Integer.MAX_VALUE) {
                return 0;
            }
            int result = Integer.valueOf(s);
            if (negativeFlag) {
                result = -result;
            }
            return result;
        } else {
            return 0;
        }
    }
}
