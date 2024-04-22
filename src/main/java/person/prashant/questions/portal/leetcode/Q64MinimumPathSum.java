package person.prashant.questions.portal.leetcode;

import person.prashant.annotations.complexity.Medium;
import person.prashant.annotations.topics.Array;
import person.prashant.annotations.topics.DynamicProgramming;
import person.prashant.annotations.topics.Matrix;
import person.prashant.utility.SolutionTester;

@Medium // Complexity
@Array @DynamicProgramming @Matrix // Topics
public class Q64MinimumPathSum {
    /**
     * https://leetcode.com/problems/minimum-path-sum/description/
     *
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     *
     * Example 2:
     *
     * Input: grid = [[1,2,3],[4,5,6]]
     * Output: 12
     *
     *
     *
     * Constraints:
     *
     *     m == grid.length
     *     n == grid[i].length
     *     1 <= m, n <= 200
     *     0 <= grid[i][j] <= 200
     */

    public static void main(String[] args) {
        SolutionTester.<int[][], Integer>startTest("Example 1.0")
                .callMethod(Q64MinimumPathSum::minPathSum)
                .withInput(new int[][]{{1,3,1},{1,5,1},{4,2,1}})
                .andExpect(7);
    }

    // 	11 ms beats 5% users
    public static int minPathSum(int[][] grid) {
        Integer[][] savedVals = new Integer[grid.length][grid[0].length];

        for (int column = 0; column < grid[0].length; column++){
            for (int row = 0; row < grid.length; row++) {
                Integer shortestPathSoFarFromLeft = column != 0 ? savedVals[row][column - 1] : row == 0 ? 0 : Integer.MAX_VALUE;
                Integer shortestPathSoFarFromTop = row != 0 ? savedVals[row - 1][column] : Integer.MAX_VALUE;
                Integer shortestPathSoFar = Math.min(shortestPathSoFarFromLeft, shortestPathSoFarFromTop);

                savedVals[row][column] = grid[row][column] + shortestPathSoFar;
            }
        }

        return savedVals[grid.length - 1][grid[0].length - 1];

    }

    // 	1 ms beats 95% users
    public static int minPathSumUsingRecursion(int[][] grid) {
        return minPathSumUsingRecursion(grid, 0, 0, new Integer[grid.length][grid[0].length]);
    }

    public static int minPathSumUsingRecursion(int[][] grid, int beginningRowIndex, int beginningColumnIndex, Integer[][] savedVals) {

        for (int i = beginningColumnIndex; i < grid[0].length; i++){
            Integer shortestPathSoFarFromLeft = i != 0 ? savedVals[beginningRowIndex][i - 1] : beginningRowIndex == 0 ? 0 : Integer.MAX_VALUE;
            Integer shortestPathSoFarFromTop = beginningRowIndex != 0 ? savedVals[beginningRowIndex - 1][i] : Integer.MAX_VALUE;
            Integer shortestPathSoFar = Math.min(shortestPathSoFarFromLeft, shortestPathSoFarFromTop);

            savedVals[beginningRowIndex][i] =  grid[beginningRowIndex][i] + shortestPathSoFar;
        }

        for (int i = beginningRowIndex + 1; i < grid.length; i++){
            Integer shortestPathSoFarFromLeft = beginningColumnIndex != 0 ? savedVals[i][beginningColumnIndex - 1] : Integer.MAX_VALUE;
            Integer shortestPathSoFarFromTop = i != 0 ? savedVals[i - 1][beginningColumnIndex] : Integer.MAX_VALUE;
            Integer shortestPathSoFar = Math.min(shortestPathSoFarFromLeft, shortestPathSoFarFromTop);

            savedVals[i][beginningColumnIndex] =  grid[i][beginningColumnIndex] + shortestPathSoFar;
        }

        if(beginningRowIndex == grid.length - 1 || beginningColumnIndex == grid[0].length - 1){
            return savedVals[grid.length - 1][grid[0].length - 1];
        } else {
            return minPathSumUsingRecursion(grid, beginningRowIndex + 1, beginningColumnIndex + 1, savedVals);
        }
    }
}
