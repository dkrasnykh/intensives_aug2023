// Extra task https://leetcode.com/problems/validate-binary-tree-nodes/

package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4DFS {
    public static void runSearch(List<Integer> path, int[][] tree, int root) {
        if (root != -1) {
            runSearch(path, tree, tree[root][0]);
            runSearch(path, tree, tree[root][1]);
            path.add(root);
        }
    }

    public static int[] getDFSOrder(int[][] tree, int root) {
        /*
         * Функция возвращает массив с порядковыми номерами вершин в обходе
         * Сначала левое поддерево, затем правое, затем корень.
         * Дано дерево из n (<= 10^5) вершин (пронумерованных от 0 до n-1)
         * tree - двумерный массив, tree[i][0] - номер левого сына, tree[i][1] - номер правого сына (если нет левого / правого сына, соотв. элемент -1)
         * root - корень, откуда нужно начинать обход
         */
        List<Integer> path = new ArrayList<>();
        runSearch(path, tree, root);
        int[] ans = new int[path.size()];
        for(int i = 0; i < path.size(); ++i){
            ans[i] = path.get(i);
        }
        return ans;
    }

    public static void selfCheck() {
        int[][] tree =
                {
                        {1, 6},
                        {2, 3},
                        {-1, -1},
                        {4, -1},
                        {-1, -1},
                        {-1, -1},
                        {-1, 8},
                        {-1, -1},
                        {-1, -1}
                };

        int[] ans1 = {2, 4, 3, 1, 8, 6, 0};
        int[] ans2 = {4, 3};
        int[] ans3 = {2};
        int[] ans4 = {8, 6};

        assert (Arrays.equals(getDFSOrder(tree, 0), ans1));
        assert (Arrays.equals(getDFSOrder(tree, 3), ans2));
        assert (Arrays.equals(getDFSOrder(tree, 2), ans3));
        assert (Arrays.equals(getDFSOrder(tree, 6), ans4));
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
