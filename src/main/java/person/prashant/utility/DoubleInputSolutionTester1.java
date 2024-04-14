package person.prashant.utility;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;

public class DoubleInputSolutionTester1<Input1, Input2, Output> extends AbstractTester<Output>{
    private String name;
    private Input1 input1;
    private Input2 input2;
    BiFunction<Input1, Input2, Output> solution;

    private DoubleInputSolutionTester1(){}

    public static <Input1, Input2, Output> DoubleInputSolutionTester1<Input1, Input2, Output> startTest(){
        return new DoubleInputSolutionTester1<>();
    }

    public static <Input1, Input2, Output> DoubleInputSolutionTester1<Input1, Input2, Output> startTest(String name){
        return new DoubleInputSolutionTester1<Input1, Input2, Output>().name(name);
    }

    public DoubleInputSolutionTester1<Input1, Input2, Output> name(String n) {
        this.name = n;
        return this;
    }

    public DoubleInputSolutionTester1<Input1, Input2, Output> callMethod(BiFunction<Input1, Input2, Output> solution) {
        this.solution = solution;
        return this;
    }

    public DoubleInputSolutionTester1<Input1, Input2, Output> withInput(Input1 i1, Input2 i2) {
        this.input1 = i1;
        this.input2 = i2;
        return this;
    }


    public static void failFast() {
        failFast = true;
    }

    @Override
    protected Callable<Output> method() {
        return () -> this.solution.apply(this.input1, this.input2);
    }

    @Override
    protected String getName() {
        return name;
    }
}
