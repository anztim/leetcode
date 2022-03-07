package leetcode.lc735;

import tools.ArrayStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author anztim
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> resultList = new LinkedList<>();
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                boolean alive = true;
                asteroid *= -1;
                while (alive && !stack.isEmpty()) {
                    int top = stack.peek();
                    if (asteroid >= top) {
                        stack.pop();
                    }
                    if(asteroid <= top){
                        alive = false;
                    }
                }
                if (alive) resultList.add(-asteroid);
            }
        }
        resultList.addAll(stack);
        return resultList.stream().mapToInt(Integer::valueOf).toArray();
    }
}
