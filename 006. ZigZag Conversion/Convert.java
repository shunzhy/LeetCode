public class Convert {

    public static String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if(numRows <= 1 || s.length() < 3 || s.length() <= numRows) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            // 每行的间隔numRows*2-2，必有字符
            for (int j = i; j < s.length(); j += numRows*2-2) {
                sb.append(s.charAt(j));

                if (i != 0 && i != numRows - 1) {
                    int t = j + 2 * (numRows - i - 1);
                    // 除首位两行外，存储的字符位置：j + 2 * (numRows - i - 1)
                    if (t < s.length() && t > 0) {
                        sb.append(s.charAt(t));
                    }
                }
            }
        }
        return sb.toString();
    }
}
