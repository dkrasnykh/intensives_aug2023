// Extra task https://leetcode.com/problems/valid-parentheses/

package ru.yandex.tasks;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Task6BraceBalance {
    public static boolean checkBalance(String sequence) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');
        for (int i = 0; i < sequence.length(); ++i) {
            char c = sequence.charAt(i);
            if (closeToOpen.containsValue(c)) {
                stack.addLast(c);
            } else if (stack.isEmpty() || stack.getLast() != closeToOpen.get(c)) {
                return false;
            } else {
                stack.pollLast();
            }
        }
        return stack.isEmpty();
    }

    public static void selfCheck() {
        String test1 = "[({})]{[]}";
        String test2 = "{({})}{";

        assert checkBalance(test1);
        assert !checkBalance(test2);
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
