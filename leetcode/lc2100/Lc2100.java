package leetcode.lc2100;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anztim
 */
public class Lc2100 {
    public static void main(String[] args) throws Exception {
        Testcase.setSolution("leetcode.lc2100.Solution","goodDaysToRobBank");
        List<Testcase> testcases = new ArrayList<>();
        testcases.add(new Testcase(new int[]{2, 1, 1, 0}, 1));
        testcases.add(new Testcase(new int[]{1, 1, 1, 1, 1}, 0));
        testcases.add(new Testcase(new int[]{1, 2, 3, 1, 5}, 0));
        testcases.add(new Testcase(new int[]{1, 2, 3, 4, 5, 6}, 2));
        int i = 1;
        for (Testcase testcase : testcases) {
            System.out.println("Case " + i++ + ":");
            testcase.run();
            System.out.println();
        }
    }
}

class Testcase {
    int[] security;
    int time;
    static Class<?> solutionClass;
    static Method method;

    public Testcase(int[] security, int time) {
        this.security = security;
        this.time = time;
    }

    public void run() throws Exception {
        Object returnValue;
        Object solution = solutionClass.newInstance();
        long startTime = System.currentTimeMillis();
        returnValue = method.invoke(solution, security, time);
        long endTime = System.currentTimeMillis();
        System.out.println(returnValue);
        System.out.println("Time: " + (endTime - startTime) + " ms");
    }

    public static void setSolution(String classFullName, String methodName) throws Exception {
        Testcase.solutionClass = Class.forName(classFullName);
        Testcase.method = solutionClass.getMethod(methodName, int[].class, int.class);
    }
}
