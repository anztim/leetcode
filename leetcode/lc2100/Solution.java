package leetcode.lc2100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anztim
 */
@SuppressWarnings("unused")
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int len = security.length;
        List<Integer> goodDays = new ArrayList<>();
        boolean prevDayGood = false;
        for (int i = time; i < len - time; i++) {

            if (prevDayGood && security[i] == security[i - 1] && security[i + time] >= security[i + time - 1]) {
                goodDays.add(i);
                continue;
            }
            int j;
            for (j = 0; j < time; j++) {
                if (!(security[i - j] <= security[i - j - 1] && security[i + j] <= security[i + j + 1])) {
                    break;
                }
            }
            prevDayGood = (j == time);
            if (prevDayGood) {
                goodDays.add(i);
            }
        }
        return goodDays;
    }
}
