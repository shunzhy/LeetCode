package com.shun.java.LeetCode;

/**
 * 38. Count and Say
 * @author zhengyingshun
 * @date 2018-08-15 9:13
 */
public class CountAndSay {

    /**
     * 斐波那契数列
     * @Author zhengyingshun
     * @Date 2018/8/15 9:13
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String sayPre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char preChar = sayPre.charAt(0);
        for (char c : sayPre.toCharArray()) {
            if (preChar == c) {
                count++;
            } else {
                sb.append(count).append(preChar);
                preChar = c;
                count = 1;
            }
        }
        sb.append(count).append(preChar);
        return sb.toString();
    }

}
