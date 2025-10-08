package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayOfInts {
    int sumOfUniqueValidNumbers(int[] numbers) {
//        throw new RuntimeException("Not yet implemented");
        if (numbers == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        if (numbers.length == 0) {
            return 0;
        }
        Set<Integer> a = new HashSet<>();
        int sum = 0;
        for (int n : numbers) {
            if (n < 0) {
                throw new IllegalArgumentException("Input array cannot be negative");
            }
            if (n > 1000) {
                continue;
            }
            if (a.add(n)) {
                sum += n;
            }
        }
        return sum;
    }

    int[] findUniqueElements(int[] arr1, int[] arr2){
        if (arr1 == null || arr2.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        Set<Integer> a = new HashSet<>();
        for (int x : arr1) a.add(x);
        Set<Integer> b = new HashSet<>();
        for (int y : arr2) b.add(y);

        Set<Integer> r = new HashSet<>();

        for (int x : a){
            if (!b.contains(x)) r.add(x);
        }

        for (int y : b){
            if (!a.contains(y)) r.add(y);
        }

        int[] o = r.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(o);
        return o;
    }

//
}
