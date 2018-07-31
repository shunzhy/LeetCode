package com.shun.java.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 36. Valid Sudoku
 * @author zhengyingshun
 * @date 2018-07-31 9:30
 */
public class ValidSudoku {

    /**
     *
     * @Author zhengyingshun
     * @Date 2018/7/31 9:30
     */
    public boolean isValidSudoku(char[][] board) {
        List<Character> list;
        // i代表行，j代表列
        for (int i = 0; i < 9; i++) {
            list = new ArrayList<Character>(9);
            // row
            int i1 = i, j1 = 0;
            for (; j1 < 9; j1++) {
                if (board[i1][j1] != '.' && list.contains(board[i1][j1])) {
                    return false;
                }
                list.add(board[i1][j1]);
            }
            list = new ArrayList<Character>(9);
            // column
            int i2 = 0, j2 = i;
            for (; i2 < 9; i2++) {
                if (board[i2][j2] != '.' && list.contains(board[i2][j2])) {
                    return false;
                }
                list.add(board[i2][j2]);
            }
            list = new ArrayList<Character>(9);
            // 3*3
            int i3 = i % 3 * 3;
            for (; i3 < i % 3 * 3 + 3; i3++) {
                for (int j3 = i / 3 * 3; j3 < i / 3 * 3 + 3; j3++) {
                    if (board[i3][j3] != '.' && list.contains(board[i3][j3])) {
                        return false;
                    }
                    list.add(board[i3][j3]);
                }
            }
        }
        return true;
    }

}
