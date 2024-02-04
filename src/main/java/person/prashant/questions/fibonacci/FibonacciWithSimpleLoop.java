package person.prashant.questions.fibonacci;

public class FibonacciWithSimpleLoop {
    public static void main(String[] args) {

        int i = 100; // input

        if(i <= 1){
            print(i);
        } else {

            int first = 0;
            int second = 1;

            for (int num = 2; num <= i; num++) {
                int res = first + second;
                first = second;
                second = res;
                print(second);
            }

        }
    }

    private static void print(int j){
        System.out.println("Result is - " + j);
    }
}
