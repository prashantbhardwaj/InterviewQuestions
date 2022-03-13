package person.prashant.common.questions.basic;
/*
Question - Find maximum product of 3 numbers in an array.

Given an array of integers, which can contain both +ve and -ve numbers.
I've to maximize the product of any 3 elements of the array. The elements can be non-contiguous.

Examples -
int[] arr = {-5, -7, 4, 2, 1, 9};  // Max Product of 3 numbers = -5 * -7 * 9
int[] arr2 = {4, 5, -19, 3};       // Max Product of 3 numbers = 4 * 5 * 3

 */
public class Find3NumbersToMakeLargestMultiplication {

    /*
    could be solve using 5 variables with O(n) pass.
    Max Product can be formed by either:
    1. Max1 * Max2 * Max3
    2. Max1 * Min1 * min2
    where Max is maximum element and Min stands for minimum
     */
    static int maxProduct(int[] arr) {
        int max1, max2, max3 = Integer.MIN_VALUE;
        max1 = max3;
        max2 = max3;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int n : arr) {
            if (n <= min1) {            // n is smaller than all
                min2 = min1;
                min1 = n;
            } else if (n < min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than all
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies betweeen max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n > max3) {     // n lies betwen max2 and max3
                max3 = n;
            }
        }
        int ans1 = max1 * max2 * max3;
        int ans2 = max1 * min1 * min2;

        return ans1 >= ans2 ? ans1 : ans2;
    }

    private static void compareOrFail(int a, int b){
        if(a != b){
            throw new RuntimeException(String.format("int [%d] and [%d] are not equal", a, b));
        }
    }

    public static void main(String[] args) {
        compareOrFail(maxProduct(new int[]{1, 2, 3, 4}),24);
        compareOrFail(maxProduct(new int[]{-5, -7, 4, 2, 1, 9}),315);
        compareOrFail(maxProduct(new int[]{4, 5, -19, 3}),60);
        compareOrFail(maxProduct(new int[]{-1, -2, -3, -4}),-6);
        compareOrFail(maxProduct(new int[]{1, -2, -3, -4}),12);
    }
}
