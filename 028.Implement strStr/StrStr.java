public class StrStr {

    /**
     * 
     * @param 
     * @Author zhengyingshun
     * @Date 2018/3/27 8:46
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    
    /**
     * 未优化版本
     * @param 
     * @Author zhengyingshun
     * @Date 2018/3/27 8:46
     */
    public int strStr1(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int j;
        for (int i = 0; i < haystack.length(); i++) {
            j = 0;
            for (int h = i; h < haystack.length() && h < i + needle.length(); h++, j++) {
                if (haystack.charAt(h) != needle.charAt(j)) {
                    break;
                }
                if (needle.length() - 1 == j) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 参考string源码做了优化
     * @param 
     * @Author zhengyingshun
     * @Date 2018/3/27 8:46
     */
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int j;
        int max = haystack.length() - needle.length();
        // 循环i，无需全部循环
        for (int i = 0; i <= max; i++) {
            j = 0;
            // 只做循环，无循环体
            for (int h = i; j < needle.length() && haystack.charAt(h) == needle.charAt(j); h++, j++);
            // 将判断放到循环体外
            if (needle.length() == j) {
                return i;
            }
        }
        return -1;
    }
}
