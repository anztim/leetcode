package leetcode.lc2055;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anztim
 */
public class Lc2055 {
    public static void main(String[] args) {
        List<Testcase> testcases = new ArrayList<>();
        testcases.add(new Testcase("**|**|***|", new int[][]{{2, 5}, {5, 9}}));
        testcases.add(new Testcase("***|**|*****|**||**|*", new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}}));
        int i = 1;
        for (Testcase testcase : testcases) {
            System.out.println("Case " + i++ + ":");
            testcase.run();
            System.out.println();
        }
    }
}

class Testcase {
    String s;
    int[][] queries;

    public Testcase(String s, int[][] queries) {
        this.s = s;
        this.queries = queries;
    }

    public void run() {
        int[] returnValue;
        Solution solution = new Solution();
        long startTime = System.currentTimeMillis();
        returnValue = solution.platesBetweenCandles(s, queries);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(returnValue));
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}