package leetcode.lc56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author anztim
 */
public class Lc56 {
}


class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return intervals;
    }
}