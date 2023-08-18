// Extra task https://leetcode.com/problems/sort-vowels-in-a-string/

package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task1BubbleSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 2; ++i) {
            for(int j = 0; j < numbers.size() - i - 2; ++j){
                if(numbers.get(j) > numbers.get(j + 1)){
                    int tmp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, tmp);
                }
            }
        }
        return numbers;
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
