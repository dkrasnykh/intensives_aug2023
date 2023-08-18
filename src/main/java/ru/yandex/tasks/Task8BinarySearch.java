// Extra task https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

package ru.yandex.tasks;

public class Task8BinarySearch {
    public static int find(int number, int[] sortedList) {
        /*
         * number: целое число, -10^5 <= number <= 10^5
         * numbers: массив целых чисел, 0 <= numbers.length <= 10^5
         * Выход: i, где numbers[i] = number, -1, если такого i нет
         * Если таких i несколько, вывести наибольший
         */
        int l = 0, r = sortedList.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (sortedList[m] <= number) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if(r >= 0 && r < sortedList.length && sortedList[r] == number){
            return r;
        } else {
            return -1;
        }
    }

    public static void selfCheck() {
        int[] input1 = {1, 3, 5, 5, 7, 7, 9};
        assert (find(5, input1) == 3);

        input1 = new int[]{9, 9, 9, 9, 9, 9};
        assert (find(9, input1) == 5);
        assert (find(10, input1) == -1);

        int[] input = {1, 3, 5, 7, 9};

        for (int i = 0; i < input.length; i++) {
            assert (find(input[i], input) == i);
        }
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
