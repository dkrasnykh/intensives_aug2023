// Extra task https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/

package ru.yandex.tasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5BFS {
    public static void runSearch(List<Integer> path, int[][] tree, int root) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int v = q.pollFirst();
            path.add(v);
            if (tree[v][0] != -1) {
                q.addLast(tree[v][0]);
            }
            if (tree[v][1] != -1) {
                q.addLast(tree[v][1]);
            }
        }
    }

    public static int[] getBFSOrder(int[][] tree, int root) {
        /*
         * Функция возвращает массив с порядковыми номерами вершин в обходе
         * Дано дерево из n (<= 10^5) вершин (пронумерованных от 0 до n-1)
         * tree - двумерный массив, tree[i][0] - номер левого сына, tree[i][1] - номер правого сына (если нет левого / правого сына, соотв. элемент -1).
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

        int[] ans1 = {0, 1, 6, 2, 3, 8, 4};
        int[] ans2 = {3, 4};
        int[] ans3 = {2};
        int[] ans4 = {6, 8};

        assert (Arrays.equals(getBFSOrder(tree, 0), ans1));
        assert (Arrays.equals(getBFSOrder(tree, 3), ans2));
        assert (Arrays.equals(getBFSOrder(tree, 2), ans3));
        assert (Arrays.equals(getBFSOrder(tree, 6), ans4));
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
