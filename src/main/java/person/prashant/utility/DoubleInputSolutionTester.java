package person.prashant.utility;

import java.util.function.BiFunction;

public class DoubleInputSolutionTester<Input1, Input2, Output>{
    private String name;
    private Input1 input1;
    private Input2 input2;
    private Output actualOutput;
    BiFunction<Input1, Input2, Output> solution;

    private DoubleInputSolutionTester(){}

    public static <Input1, Input2, Output> DoubleInputSolutionTester<Input1, Input2, Output> startTest(){
        return new DoubleInputSolutionTester<>();
    }

    public static <Input1, Input2, Output> DoubleInputSolutionTester<Input1, Input2, Output> startTest(String name){
        return new DoubleInputSolutionTester<Input1, Input2, Output>().name(name);
    }

    public DoubleInputSolutionTester<Input1, Input2, Output> name(String n) {
        this.name = n;
        return this;
    }

    public DoubleInputSolutionTester<Input1, Input2, Output> callMethod(BiFunction<Input1, Input2, Output> solution) {
        this.solution = solution;
        return this;
    }

    public DoubleInputSolutionTester<Input1, Input2, Output> withInput(Input1 i1, Input2 i2) {
        this.input1 = i1;
        this.input2 = i2;
        return this;
    }

    public void andExpect(Output expectedOutput){
        String newName = name == null ? "" : "[" + name + "]" + " = ";
        Output actualOutput = this.solution.apply(this.input1, this.input2);
        if (!expectedOutput.equals(actualOutput)) {
            System.out.println(newName + "test failed");
            throw new AssertionError(expectedOutput.getClass().getSimpleName() + " are not equal. Expected: " + expectedOutput + ", Actual: " + actualOutput);
        } else {
            System.out.println(newName + "test passed");
        }
    }
}
