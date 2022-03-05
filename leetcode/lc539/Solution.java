package leetcode.lc539;

import java.util.Arrays;
import java.util.List;

/**
 * @author anztim
 */
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] times = new int[len];
        for (int i = 0; i < len; i++) {
            String timePoint = timePoints.get(i);
            times[i] = Integer.parseInt(timePoint.substring(0, 2)) * 60
                    + Integer.parseInt(timePoint.substring(3, 5));
        }
        Arrays.sort(times, 0, len);
        int minDifference = 1440;
        int i;
        for (i = 1; i < len; i++) {
            minDifference = Math.min(times[i] - times[i - 1], minDifference);
        }
        minDifference = Math.min(times[0] - times[i - 1] + 1440, minDifference);
        return minDifference;
    }
}
