package com.shun.java.LeetCode;

/**
 * Divide Two Integers
 * @author zhengyingshun
 * @date 2018-03-27 16:00
 */
public class Divide {

    public int divide(int a, int b) {
        if (b == 0) {
            return Integer.MAX_VALUE;
        }
        // 处理两数相等
        if (a == b) {
            return 1;
        }
        // 当除数为负数最大值的，任何数 除以 除数都为0
        if (b == Integer.MIN_VALUE) {
            return 0;
        }
        int i = 0;
        int quotient = 0; //商
        int divisor = b > 0 ? b : ~b + 1;
        // 处理当被除数为负数最大值时，为避免求绝对值时溢出，先进行一次操作
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            } else if (b == -1) {
                return Integer.MAX_VALUE;
            }
            quotient++;
            a += divisor;
            i++;
        }
        // 先取被除数和除数的绝对值
        int dividend = a > 0 ? a : ~a + 1;

        while (dividend >= divisor) {
            //if (dividend >= divisor << i) {
            if ((dividend >> i) >= divisor) {
                quotient += 1 << i;
                dividend -= divisor << i;
                i++;
            } else {
                i--;
            }
        }

        return (a ^ b) < 0 ? ~quotient + 1 : quotient;
    }

}
