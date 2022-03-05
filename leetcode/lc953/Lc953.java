package leetcode.lc953;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href=https://leetcode-cn.com/problems/verifying-an-alien-dictionary/>LeetCode 953. 验证外星语词典</a><br/>
 * <a href=https://leetcode-cn.com/problems/lwyVBB/>剑指 Offer II 034. 外星语言是否排序</a>
 * @see Solution
 * @author anztim
 */
public class Lc953 {
    public static void main(String[] args) {
        List<Testcase> testcases = new ArrayList<>();
        testcases.add(new Testcase(
                new String[]{"hello", "leetcode"},
                "hlabcdefgijkmnopqrstuvwxyz")
        );
        testcases.add(new Testcase(
                new String[]{"word", "world", "row"},
                "worldabcefghijkmnpqstuvxyz")
        );
        testcases.add(new Testcase(
                new String[]{"apple", "app"},
                "abcdefghijklmnopqrstuvwxyz")
        );
        testcases.add(new Testcase(
                new String[]{"app", "apple"},
                "abcdefghijklmnopqrstuvwxyz")
        );
        int i = 1;
        for (Testcase testcase : testcases) {
            System.out.println("Case " + i++ + ": ");
            testcase.run();
            System.out.println();
        }
    }
}

class Testcase {
    String[] words;
    String orderStr;

    public Testcase(String[] words, String orderStr) {
        this.words = words;
        this.orderStr = orderStr;
    }

    public void run() {
        boolean returnValue;
        Solution solution = new Solution();
        long startTime = System.currentTimeMillis();
        returnValue = solution.isAlienSorted(words, orderStr);
        long endTime = System.currentTimeMillis();
        System.out.println(returnValue);
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }
}


