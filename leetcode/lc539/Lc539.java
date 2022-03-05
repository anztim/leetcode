package leetcode.lc539;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href=https://leetcode-cn.com/problems/minimum-time-difference/>
 * LeetCode 593. 最小时间差
 * </a><br/>
 * <a href=https://leetcode-cn.com/problems/569nqc/>
 * 剑指 Offer II 035. 最小时间差
 * </a><br/>
 * @author anztim
 * @see Solution
 */
public class Lc539 {
    public static void main(String[] args) {
        List<Testcase> testcases = new ArrayList<>();
        testcases.add(new Testcase(Arrays.asList("23:59", "00:00")));
        testcases.add(new Testcase(Arrays.asList("00:00","23:59","00:00")));
        int i = 1;
        for (Testcase testcase : testcases) {
            System.out.println("Case " + i + ":");
            testcase.run();
            System.out.println();
        }
    }
}

class Testcase {
    List<String> timePoints;

    public Testcase(List<String> timePoints) {
        this.timePoints = timePoints;
    }

    public void run() {
        int returnValue;
        Solution solution = new Solution();
        long startTime = System.currentTimeMillis();
        returnValue = solution.findMinDifference(timePoints);
        long endTime = System.currentTimeMillis();
        System.out.println(returnValue);
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}
