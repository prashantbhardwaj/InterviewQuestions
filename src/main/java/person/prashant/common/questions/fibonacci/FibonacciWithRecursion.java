package person.prashant.common.questions.fibonacci;

public class FibonacciWithRecursion {
    private static final int fib(int i){
        if(i <= 0)
            return 0;
        if (i <=2)
            return 1;
        else
            return fib(i - 1) + fib(i-2);
    }

    public static void main(String[] args) {
        assertEqual(0, fib(0));
        assertEqual(1, fib(1));
        assertEqual(1, fib(2));
        assertEqual(2, fib(3));
        assertEqual(3, fib(4));
        assertEqual(3, fib(100));
        System.out.println("All test cases passed");
    }

    private static void assertEqual(int expected, int compareTo){
        if(expected != compareTo)
            throw new RuntimeException(expected + " is expected but got " + compareTo);
    }
}
