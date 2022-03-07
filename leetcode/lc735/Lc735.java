package leetcode.lc735;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href=https://leetcode-cn.com/problems/asteroid-collision/>735. 行星碰撞</a><br/>
 * <a href=剑指 Offer II 037. 小行星碰撞>剑指 Offer II 037. 小行星碰撞</a><br/>
 * @author anztim
 */
public class Lc735 {
    public static void main(String[] args) {
        List<Testcase> testcases = new ArrayList<>();
        testcases.add(new Testcase(new int[]{5,10,-5}));
        testcases.add(new Testcase(new int[]{8,-8}));
        testcases.add(new Testcase(new int[]{10,2,-5}));
        testcases.add(new Testcase(new int[]{-2,-1,1,2}));
        int i = 1;
        for (Testcase testcase : testcases) {
            System.out.println("Case " + i++ + ":");
            testcase.run();
            System.out.println();
        }
    }
}

class Testcase {
    int[] asteroids;

    public Testcase(int[] asteroids) {
        this.asteroids = asteroids;
    }

    public void run() {
        int[] returnValue;
        Solution solution = new Solution();
        long startTime = System.currentTimeMillis();
        returnValue = solution.asteroidCollision(asteroids);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(returnValue));
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}
