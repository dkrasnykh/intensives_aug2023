// Extra task https://leetcode.com/problems/minimum-index-of-a-valid-split/

package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2SelectionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        for(int i = 0; i < numbers.size() - 1; ++i){
            int imin = i;
            for(int j = i; j < numbers.size(); ++j){
                if(numbers.get(imin) > numbers.get(j)){
                    imin = j;
                }
            }
            int tmp = numbers.get(i);
            numbers.set(i, numbers.get(imin));
            numbers.set(imin, tmp);
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
