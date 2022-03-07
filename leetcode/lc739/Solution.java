package leetcode.lc739;

import tools.ArrayStack;

/**
 * @author anztim
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < len; i++) {
            int top;
            while (!stack.isEmpty()) {
                top = stack.peek();
                if (temperatures[i] > temperatures[top]){
                    result[top] = i - top;
                    stack.pop();
                } else break;
            }
            stack.push(i);
        }
        return result;
    }
}
