package leetcode.lc739;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href=https://leetcode-cn.com/problems/daily-temperatures/>739. 每日温度</a><br/>
 * <a href=https://leetcode-cn.com/problems/iIQa4I/>剑指 Offer II 038. 每日温度</a><br/>
 *
 * @author anztim
 */
public class Lc739 {
    public static void main(String[] args) {
        List<Testcase> testcases = new ArrayList<>();
        testcases.add(new Testcase(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        testcases.add(new Testcase(new int[]{30, 40, 50, 60}));
        testcases.add(new Testcase(new int[]{30, 60, 90}));
        int i = 1;
        for (Testcase testcase : testcases) {
            System.out.println("Case " + i++ + ":");
            testcase.run();
            System.out.println();
        }
    }
}

class Testcase {
    int[] temperatures;

    public Testcase(int[] temperatures) {
        this.temperatures = temperatures;
    }

    public void run() {
        int[] returnValue;
        Solution solution = new Solution();
        long startTime = System.currentTimeMillis();
        returnValue = solution.dailyTemperatures(temperatures);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(returnValue));
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}
