package person.prashant.questions.portal.leetcode;

import java.util.Arrays;

/*
https://leetcode.com/problems/longest-consecutive-sequence/
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9



Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109


 */
public class Q128LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println("I: 100,4,200,1,3,2");
        //int result1 = longestConsecutive(100,4,200,1,3,2);
        //System.out.println(result1);

        System.out.println("I: 0,3,7,2,5,8,4,6,0,1");
        int result2 = longestConsecutive(0,3,7,2,5,8,4,6,0,1);
        System.out.println(result2);
    }

    public static int longestConsecutive(int... nums) {
        Arrays.sort(nums);

        int currentResult = 0;
        int bestResult = 0;

        int previousNum = 0;
        boolean starting = true;

        for (int i : nums){
            if (previousNum + 1 == i){
                currentResult++;
            } else if (previousNum != i){
                currentResult = 1;
            }

            if (starting){
                currentResult = 1;
                starting = false;
            }

            if (currentResult >= bestResult){
                bestResult = currentResult;
            }

            previousNum = i;
        }

        return bestResult;
    }
}
