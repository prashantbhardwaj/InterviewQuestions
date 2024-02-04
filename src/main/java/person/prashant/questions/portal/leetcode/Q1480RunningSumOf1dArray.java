package person.prashant.questions.portal.leetcode;


/**
 Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

 Return the running sum of nums.



 Example 1:

 Input: nums = [1,2,3,4]
 Output: [1,3,6,10]
 Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

 Example 2:

 Input: nums = [1,1,1,1,1]
 Output: [1,2,3,4,5]
 Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

 Example 3:

 Input: nums = [3,1,2,10,1]
 Output: [3,4,6,16,17]

 */
public class Q1480RunningSumOf1dArray {

    public static void main(String[] args) {
        System.out.println("I: 1,2,3,4");
        runningSum(1,2,3,4);
        System.out.println();

        System.out.println("I: 1,1,1,1,1");
        runningSum(1,1,1,1,1);
        System.out.println();

        System.out.println("I: 3,1,2,10,1");
        runningSum(3,1,2,10,1);
        System.out.println();

    }

    public static int[] runningSum(int... nums) {
        int size =  nums != null ? nums.length : 0;
        int[] result = new int[size];
        int prev = 0;
        for(int i=0; i < size; i++){
            int sum = prev + nums[i];
            result[i] = sum;
            prev = sum;
        }
        return result;
    }
}
