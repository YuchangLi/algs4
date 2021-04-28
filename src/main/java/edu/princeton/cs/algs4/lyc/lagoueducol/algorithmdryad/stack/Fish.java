package edu.princeton.cs.algs4.lyc.lagoueducol.algorithmdryad.stack;

import java.util.Stack;

/**
 * @author liyuchang
 * @Date 2021-04-01 21:28
 */
public class Fish {

    public static void main(String[] args) {
        int[] size = {4, 2, 5, 3, 1, 3}, dir = {1, 1, 0, 0, 0, 1};
        System.out.println(solution(size, dir));
        System.out.println(solution2(size, dir));

    }

    static int solution(int[] size, int[] dir) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size.length; i++) {
            // 为空直接放入
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            Integer fishIndex = stack.peek();
            // 同方向直接放入
            if (dir[i] == dir[fishIndex]) {
                stack.push(i);
                continue;
            }
            // 不同方向(新的鱼是向右)，直接加入
            if (dir[i] == 1) {
                stack.push(i);
                continue;
            }
            // 不同方向(新的鱼是向左)，小于第一个，不放入
            if (size[i] < size[fishIndex]) {
                continue;
            }

            // 不同方向，大于第一个，判断需要吃几个
            while (true) {
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                fishIndex = stack.peek();
                if (dir[i] == dir[fishIndex]) {
                    break;
                }
                if (size[i] < size[fishIndex]) {
                    break;
                }
            }
            stack.push(i);
        }
        return stack.size();
    }

    static int solution2(int[] size, int[] dir) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size.length; i++) {
            // 当前鱼与栈顶鱼相向时，才会有鱼被吃
            boolean hasEat = false;
            while (!stack.isEmpty() && dir[stack.peek()] == 1 && dir[i] == 0) {
                // 当前鱼小于栈顶鱼， 被吃
                if (size[i] < size[stack.peek()]) {
                    hasEat = true;
                    break;
                }
                // 当前鱼小于栈顶鱼， 吃掉栈顶鱼
                stack.pop();
            }
            if (!hasEat) {
                stack.push(i);
            }
        }
        return stack.size();
    }

}
