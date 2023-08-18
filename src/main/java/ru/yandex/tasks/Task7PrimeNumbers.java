// Extra task https://leetcode.com/problems/prime-in-diagonal/

package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Task7PrimeNumbers {
    public static int[] findPrimes (int N) {
        List<Boolean> boolArr = new ArrayList<>();
        for(int i = 0; i <= N; ++i){
            boolArr.add(true);
        }
        boolArr.set(0, false);
        boolArr.set(1, false);
        for (int i = 2; i * i < boolArr.size(); i++) {
            if (boolArr.get(i)) {
                for (int j = i * i; j < boolArr.size(); j += i) {
                    boolArr.set(j, false);
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < boolArr.size(); i++) {
            if (boolArr.get(i)) {
                primes.add(i);
            }
        }
        int[] res = new int[primes.size()];
        for(int i = 0; i < primes.size(); ++i){
            res[i] = primes.get(i);
        }
        return res;
    }

    public static void selfCheck() {
        int[] output = {2, 3, 5};

        assert (Arrays.equals(output, findPrimes(5)));
    }

    public static void main(String[] args) {
        selfCheck();
    }
}
