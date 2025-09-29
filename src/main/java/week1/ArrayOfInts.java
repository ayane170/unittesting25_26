package week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfInts {
    public int sumOfInts(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;
        int sum = 0;
        for (int i : arrayOfInts)
            sum += i;
        return sum;
    }

    public int sumOf3SmallestInts(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;
        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Arrays.sort(copy);
        return sumOfInts(Arrays.copyOf(copy, 3));
    }

    public int sumOfEven(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;
        int[] even = new int[arrayOfInts.length];
        int evenLength = 0;
        for (int i : arrayOfInts)
            if (i % 2 == 0) even[evenLength++] = i;
        return sumOfInts(even);
    }

    public int sumOfXLargest(int[] arrayOfInts, int x) {
        if (arrayOfInts == null) return 0;
        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Arrays.sort(copy);
        int A = Math.min(x, copy.length);
        int sum = 0;
        for (int i = copy.length - 1 ; i>= copy.length - A ; i--){
            sum+= copy[i];
        }
        return sum;
    }

    public int countMostPopularNumber(int[] arrayOfInts) {
        if (arrayOfInts == null || arrayOfInts.length == 0) return 0;
        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : copy) {
            countMap.compute(i, (key, value) -> value == null ? 1 : value + 1);
        }

        Integer[] values = countMap.values().toArray(new Integer[0]);
        Arrays.sort(values);

        return values[values.length - 1];
    }

}
