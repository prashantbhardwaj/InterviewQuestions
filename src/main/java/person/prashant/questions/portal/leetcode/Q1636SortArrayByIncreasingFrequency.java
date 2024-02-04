package person.prashant.questions.portal.leetcode;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Q1636SortArrayByIncreasingFrequency {

    public static void main(String[] args) {
        System.out.println("I: 1,2,3");
        int[] result1 = frequencySort(1,2,3);
        System.out.println(Arrays.toString(result1));

        System.out.println("I: 3,2,1");
        int[] result2 = frequencySort(3,2,1);
        System.out.println(Arrays.toString(result2));

        System.out.println("I: 1,2,2,3,3,3");
        int[] result3 = frequencySort(1,2,2,3,3,3);
        System.out.println(Arrays.toString(result3));

        System.out.println("I: 1,2,3,4,4,5,5,6,7,7,7,8");
        int[] result4 = frequencySort(1,2,3,4,4,5,5,6,7,7,7,8);
        System.out.println(Arrays.toString(result4));
    }

    public static int[] frequencySort(int... nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((es1, es2) -> es1.getValue() == es2.getValue() ? Integer.compare(es2.getKey(), es1.getKey()) : Long.compare(es1.getValue(), es2.getValue()))
                .flatMap(entry -> LongStream.range(0, entry.getValue()).mapToObj(i -> entry.getKey()))
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
