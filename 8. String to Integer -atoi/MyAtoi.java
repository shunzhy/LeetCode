class Solution {
    public int myAtoi(String str) {
        // 溢出，超出int/long
        // 0
        // -321
        // 非整形
        // +1
        // -+1
        // "    010"
        // +
        // "1232A34"
        // "   a12334"
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) || c == '+' || c == '-') {
                sb.append(c);
            } else {
                if (sb.length() > 0 || c != ' ') {
                    break;
                }
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        str = sb.toString();
        String regex = "[-+]?[0-9]+";
        if (!str.matches(regex)) {
            return 0;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            if (str.contains("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}
