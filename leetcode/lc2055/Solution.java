package leetcode.lc2055;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anztim
 */
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] left = new int[len];
        int[] right = new int[len];
        List<Integer> candles = new ArrayList<>();
        int pr = 0;// pointer for right[]
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '|') {
                Arrays.fill(right, pr, i+1, candles.size());
                pr = i+1;
                candles.add(i);
            }
            left[i] = candles.size() - 1;
        }
        Arrays.fill(right, pr, len, -1);

        int qlen = queries.length;
        int[] result = new int[qlen];
        for (int i = 0; i < qlen; i++) {
            int[] cur = queries[i];
            int leftCandleIdx = right[cur[0]];
            int rightCandleIdx = left[cur[1]];
            if (leftCandleIdx != -1 && rightCandleIdx != -1 && leftCandleIdx < rightCandleIdx) {
                int leftCandle = candles.get(leftCandleIdx);
                int rightCandle = candles.get(rightCandleIdx);
                result[i] = rightCandle - leftCandle - rightCandleIdx + leftCandleIdx;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}