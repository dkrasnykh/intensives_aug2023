package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task10Permutations {
    private static List<Integer> permutation;

    public static void generate(boolean[] chosen, List<List<Integer>> ans, int[] numbers) {
        if (permutation.size() == numbers.length) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < numbers.length; ++i){
                list.add(permutation.get(i));
            }
            ans.add(list);
        } else {
            for(int i = 0; i < numbers.length; ++i){
                if(chosen[i]){
                    continue;
                }
                chosen[i] = true;
                permutation.add(numbers[i]);
                generate(chosen, ans, numbers);
                chosen[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    public static int[][] permutations(int[] numbers) {
        /*
         * Возвращает массив со всеми перестановками массива numbers (массив n чисел от 1 до n, 1 <= n <= 10)
         */
        permutation = new ArrayList<>();
        boolean[] chosen = new boolean[numbers.length + 1];
        List<List<Integer>> ans = new ArrayList<>();
        generate(chosen, ans, numbers);
        int[][] result = new int[ans.size()][numbers.length];
        for(int i = 0; i < ans.size(); ++i){
            for(int j = 0; j < numbers.length; ++j){
                result[i][j] = ans.get(i).get(j);
            }
        }
        return result;
    }

    public static void selfCheck() {
        int[] input = {1, 2, 3};
        int[][] output = {
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1}
        };

        assert Arrays.deepEquals(output, permutations(input));
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
