package leetcode.lc688;

import java.util.*;

/**
 * @author anztim
 */
public class Lc688 {
    public static void main(String[] args) {
        System.out.println(new Solution3().knightProbability(25, 100, 0, 0));
        System.out.println(new Solution2().knightProbability(25, 100, 0, 0));
        System.out.println(new Solution().knightProbability(3, 2, 0, 0));
    }
}

/**
 * DFS + 记忆<br/>
 * 使用 HashMap
 * @author anztim
 */
class Solution {
    int[] nav = new int[]{1, 2, -1, -2, 1, -2, -1, 2, 1};
    Map<String, Double> map;
    int n;

    public double knightProbability(int n, int k, int row, int col) {
        this.map = new HashMap<>();
        this.n = n;
        return dfs(row, col, k);
    }

    double dfs(int row, int col, int step) {
        if (!(row >= 0 && col >= 0 && row < n && col < n)) {
            return 0.0;
        }
        if (step == 0) {
            return 1.0;
        }
        String key = row + "," + col + "," + step;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        double value = 0;
        int navRow;
        int navCol = 1;
        for (int j = 1; j <= 8; j++) {
            navRow = navCol;
            navCol = nav[j];
            int nextRow = row + navRow;
            int nextCol = col + navCol;
            value += dfs(nextRow, nextCol, step - 1) / 8;
        }
        map.put(key, value);
        return value;
    }
}

/**
 * @author anztim
 * DFS + 记忆
 * 使用数组
 *
 */
class Solution2 {
    int[] nav = new int[]{1, 2, -1, -2, 1, -2, -1, 2, 1};
    double[][][] mem;
    int n;

    public double knightProbability(int n, int k, int row, int col) {
        this.mem = new double[n][n][k + 1];
        this.n = n;
        return dfs(row, col, k);
    }

    double dfs(int row, int col, int step) {
        if (!(row >= 0 && col >= 0 && row < n && col < n)) {
            return 0.0;
        }
        if (step == 0) {
            return 1.0;
        }
        if (mem[row][col][step] != 0) {
            return mem[row][col][step];
        }
        double value = 0;
        int navRow;
        int navCol = 1;
        for (int j = 1; j <= 8; j++) {
            navRow = navCol;
            navCol = nav[j];
            int nextRow = row + navRow;
            int nextCol = col + navCol;
            value += dfs(nextRow, nextCol, step - 1) / 8;
        }
        mem[row][col][step] = value;
        return value;
    }
}

/**
 * @author anztim
 * DP
 */
class Solution3 {
    int[] nav = new int[]{1, 2, -1, -2, 1, -2, -1, 2, 1};
    double[][][] mem;

    public double knightProbability(int n, int k, int row, int col) {
        this.mem = new double[n][n][k + 1];
        for (int curRow = 0; curRow < n; curRow++) {
            for (int curCol = 0; curCol < n; curCol++) {
                mem[curRow][curCol][0] = 1;
            }
        }
        int navRow;
        int navCol = 1;
        for (int step = 1; step <= k; step++) {
            for (int curRow = 0; curRow < n; curRow++) {
                for (int curCol = 0; curCol < n; curCol++) {
                    double p = 0;
                    for (int j = 1; j <= 8; j++) {
                        navRow = navCol;
                        navCol = nav[j];
                        int nextRow = curRow + navRow;
                        int nextCol = curCol + navCol;
                        if (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < n) {
                            p += mem[nextRow][nextCol][step - 1];
                        }
                    }
                    mem[curRow][curCol][step] = p / 8;
                }
            }
        }
        return mem[row][col][k];
    }
}