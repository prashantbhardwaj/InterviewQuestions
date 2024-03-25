package person.prashant.questions.portal.leetcode;

import person.prashant.utility.SolutionTester;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1:
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 *Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 *     n == height.length
 *     1 <= n <= 2 * 104
 *     0 <= height[i] <= 105
 *
 */
public class Q42TrappingRainWater {

    public static void main(String[] args) {
        SolutionTester.onlyTest("Example 10");

        SolutionTester.<int[], Integer>startTest("Example 1.0")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(null)
                .andExpect(0);

        SolutionTester.<int[], Integer>startTest("Example 1.1")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{})
                .andExpect(0);

        SolutionTester.<int[], Integer>startTest("Example 1.2")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{6})
                .andExpect(0);

        SolutionTester.<int[], Integer>startTest("Example 1")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{0, 0, 0, 0, 0, 0})
                .andExpect(0);

        SolutionTester.<int[], Integer>startTest("Example 2")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{0, 1, 2, 3, 2, 1, 0})
                .andExpect(0);

        SolutionTester.<int[], Integer>startTest("Example 3.1")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{0, 1, 0, 2})
                .andExpect(1);

        SolutionTester.<int[], Integer>startTest("Example 4")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})
                .andExpect(6);

        SolutionTester.<int[], Integer>startTest("Example 5")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{4,2,0,3,2,5})
                .andExpect(9);

        SolutionTester.<int[], Integer>startTest("Example 6")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{3,2,3})
                .andExpect(1);

        SolutionTester.<int[], Integer>startTest("Example 7")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{3,2,4})
                .andExpect(1);

        SolutionTester.<int[], Integer>startTest("Example 8")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{4,2,3})
                .andExpect(1);

        SolutionTester.<int[], Integer>startTest("Example 9")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{0,7,1,4,6})
                .andExpect(7);

        SolutionTester.<int[], Integer>startTest("Example 10")
                .callMethod(Q42TrappingRainWater::trap)
                .withInput(new int[]{0,6,1,4,7})
                .andExpect(7);

    }

    public static int trap(int[] height) {
        return trap(height, 0, 0);
    }

    public static int trap(int[] height, int previousNum, int sumSoFar) {
        // when array is empty return with 0
        if (height == null || height.length <= 2) {
            return sumSoFar;
        }

        // remove first 0's from array and remove those elements from left side which are smaller/equal than their immediate right
        int[] resultForLeft = new int[height.length - 1];
        System.arraycopy(height, 1, resultForLeft, 0, height.length - 1);


        if ((height[0] == 0 && previousNum == 0) || (height.length > 1 && height[0] <= height[1])) {
            return trap(resultForLeft, previousNum, sumSoFar);
        }

        // remove last 0's from array and remove those elements from right side which are smaller/equal than their immediate left

        int[] resultForRight = new int[height.length - 1];
        System.arraycopy(height, 0, resultForRight, 0, height.length - 1);


        if ((height[height.length - 1] == 0 && previousNum == 0) || (height.length > 1 && height[height.length - 1] <= height[height.length - 2])) {
            return trap(resultForRight, previousNum, sumSoFar);
        }


        // now start calculating the trap water from left and stop when you find an element which is equal/higher than the first element

        int indexCalculatedFromLeft = 0;
        int sumFromLeft = height[0] - height[1];

        boolean breakFoundFromLeft  = false;
        int pointerIndex = 0;
        int pointerValue = 0;

        for (int i = 2; i < height.length; i++){
            if(height[i] >= height[0]){
                indexCalculatedFromLeft = i;
                breakFoundFromLeft = true;
                break;
            } else {
                sumFromLeft = sumFromLeft + (height[0] - height[i]);
            }
        }

        if(breakFoundFromLeft) {
            int[] remainingArr = new int[height.length - indexCalculatedFromLeft];
            System.arraycopy(height, indexCalculatedFromLeft, remainingArr, 0, height.length - indexCalculatedFromLeft);

            return trap(remainingArr, previousNum, sumFromLeft + sumSoFar);
        } else {


        }

        // now start calculating the trap water from right and stop when you find an element which is equal/higher than the first element

        int indexCalculatedFromRight = 0;
        int sumFromRight = height[height.length-1] - height[height.length-2];

        boolean breakFoundFromRight  = false;

        for (int i = height.length - 3; i >= 0; i--){
            if(height[i] >= height[height.length - 1]){
                indexCalculatedFromRight = i;
                breakFoundFromRight = true;
                break;
            } else {
                sumFromRight = sumFromRight + (height[height.length-1] - height[i]);
            }
        }

        if(breakFoundFromRight) {
            int[] remainingArr = new int[indexCalculatedFromRight + 1];
            System.arraycopy(height, 0, remainingArr, 0, indexCalculatedFromRight + 1);

            return trap(remainingArr, previousNum, sumFromRight + sumSoFar);
        }

        // remove one from left and try again
        int[] remainingArr = new int[height.length - 1];
        System.arraycopy(height, 1, remainingArr, 0, height.length - 1);

        return trap(remainingArr, previousNum, sumSoFar);


    }



    private static int trapLast(int[] height){
        int first = height[0];
        //Function<Integer, Integer> adder = (i) -> i + adder.apply()

        Function<Integer, Integer>[] functions = new Function[4];

        Integer result;

        Consumer<Integer> c = new Consumer<>() {
            int sum =0;
            @Override
            public void accept(Integer o) {
                //result = result + o;
            }
        };

        for (int i = 1; i < height.length; i++){
            if (height[i] >= first){
                // stop here and calculate

            } else {
               // resultCalculator.compose(resultCalculator)
            }
        }
        return 0;
    }



}
