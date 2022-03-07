package leetcode.lc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href=https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/>150. 逆波兰表达式求值</a><br/>
 * <a href=https://leetcode-cn.com/problems/8Zf90G/>剑指 Offer II 036. 后缀表达式</a><br/>
 * @author anztim
 */
public class Lc150 {
    public static void main(String[] args) {
        List<Testcase> testcases = new ArrayList<>();
        testcases.add(new Testcase(new String[]{"2","1","+","3","*"}));
        testcases.add(new Testcase(new String[]{"4","13","5","/","+"}));
        testcases.add(new Testcase(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        int i = 1;
        for (Testcase testcase : testcases) {
            System.out.println("Case " + i++ + ":");
            testcase.run();
            System.out.println();
        }
    }
}

class Testcase {
    String[] tokens;

    public Testcase(String[] tokens) {
        this.tokens = tokens;
    }

    public void run() {
        int returnValue;
        Solution solution = new Solution2();
        long startTime = System.currentTimeMillis();
        returnValue = solution.evalRPN(tokens);
        long endTime = System.currentTimeMillis();
        System.out.println(returnValue);
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}
