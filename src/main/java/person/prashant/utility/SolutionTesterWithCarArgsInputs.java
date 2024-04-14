package person.prashant.utility;

import java.util.Arrays;
import java.util.function.Function;

public class SolutionTesterWithCarArgsInputs<Input, Output>{

    private String name;
    private Input input;
    private Output actualOutput;
    Function<Input, Output> solution;

    private static boolean testFew = false;
    private static String[] testsToBeTested;

    private SolutionTesterWithCarArgsInputs(){}

    public static <Input, Output> SolutionTesterWithCarArgsInputs<Input, Output> startTest(){
        return new SolutionTesterWithCarArgsInputs<>();
    }

    public static <Input, Output> SolutionTesterWithCarArgsInputs<Input, Output> startTest(String name){
        return new SolutionTesterWithCarArgsInputs<Input, Output>().name(name);
    }

    public static void onlyTest(String... s) {
        testFew = s != null && s.length > 0;
        testsToBeTested = s;
    }

    public SolutionTesterWithCarArgsInputs<Input, Output> name(String n) {
        this.name = n;
        return this;
    }

    public SolutionTesterWithCarArgsInputs<Input, Output> callMethod(Function<Input, Output> solution) {
        this.solution = solution;
        return this;
    }

    public SolutionTesterWithCarArgsInputs<Input, Output> withInput(Input i) {
        this.input = i;
        return this;
    }

    public void andExpect(Output expectedOutput){
        String newName = name == null ? "" : "[" + name + "]" + " = ";
        if(testFew && Arrays.asList(testsToBeTested).contains(name)) {
            Output actualOutput = this.solution.apply(this.input);
            if (!expectedOutput.equals(actualOutput)) {
                System.out.println(newName + "test failed");
                throw new AssertionError(expectedOutput.getClass().getSimpleName() + " are not equal. Expected: " + expectedOutput + ", Actual: " + actualOutput);
            } else {
                System.out.println(newName + "test passed");
            }
        } else {
            System.out.println(newName + "test skipped");
        }
    }
}
