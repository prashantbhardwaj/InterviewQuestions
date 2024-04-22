package person.prashant.questions.portal.leetcode;


import person.prashant.annotations.complexity.Easy;
import person.prashant.annotations.portals.LeetCode;
import person.prashant.utility.SolutionTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 *
 * Constraints:
 *
 *     1 <= prices.length <= 105
 *     0 <= prices[i] <= 104
 */
@Easy
@LeetCode
public class Q121BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        SolutionTester.<int[], Integer>startTest("Example 1.0")
                .callMethod(Q121BestTimeToBuyAndSellStock::maxProfit)
                .withInput(new int[]{7,1,5,3,6,4})
                .andExpect(5);

        SolutionTester.<int[], Integer>startTest("Example 2.0")
                .callMethod(Q121BestTimeToBuyAndSellStock::maxProfit)
                .withInput(new int[]{7,20,1,5,3,6,4})
                .andExpect(13);

        SolutionTester.<int[], Integer>startTest("Example 3.0")
                .callMethod(Q121BestTimeToBuyAndSellStock::maxProfit)
                .withInput(new int[]{7,6,4,3,1})
                .andExpect(0);

        SolutionTester.<int[], Integer>startTest("Example 4.0")
                .callMethod(Q121BestTimeToBuyAndSellStock::maxProfit)
                .withInput(new int[]{7,11,1,6})
                .andExpect(5);

        SolutionTester.<int[], Integer>startTest("Example 5.0")
                .callMethod(Q121BestTimeToBuyAndSellStock::maxProfit)
                .withInput(new int[]{7,11,1,6,9})
                .andExpect(7);

        SolutionTester.<int[], Integer>startTest("Example 6.0")
                .callMethod(Q121BestTimeToBuyAndSellStock::maxProfit)
                .withInput(new int[]{7,11,1,9})
                .andExpect(7);
    }

    public static int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;

        List<Integer> resultant = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int num : prices){
            if (stack.isEmpty()){
                stack.push(num);
                buy = num;
            } else {
                int what = stack.pop();
                if (num > what){

                }
            }
        }

        return 0;
    }
}
