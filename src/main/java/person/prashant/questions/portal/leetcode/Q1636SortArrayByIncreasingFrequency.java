package person.prashant.questions.portal.leetcode;

import person.prashant.annotations.complexity.Easy;
import person.prashant.annotations.topics.Array;
import person.prashant.annotations.topics.HashTable;
import person.prashant.annotations.topics.Sorting;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Easy // Complexity
@Array @HashTable @Sorting
public class Q1636SortArrayByIncreasingFrequency {
    /**
     * 1636. Sort Array by Increasing Frequency
     *
     * https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
     *
     * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
     *
     * Return the sorted array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,2,2,2,3]
     * Output: [3,1,1,2,2,2]
     * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
     *
     * Example 2:
     *
     * Input: nums = [2,3,1,3,2]
     * Output: [1,3,3,2,2]
     * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
     *
     * Example 3:
     *
     * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
     * Output: [5,-1,4,4,-6,-6,1,1,1]
     *
     *
     *
     * Constraints:
     *
     *     1 <= nums.length <= 100
     *     -100 <= nums[i] <= 100
     * @param args
     */

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
