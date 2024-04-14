package person.prashant.utility;

import java.util.Arrays;
import java.util.concurrent.Callable;

public abstract class AbstractTester <Output> {

    protected static boolean testFew = false;
    protected static String[] testsToBeTested;
    protected static boolean failFast = false;

    abstract protected Callable<Output> method();
    abstract protected String getName();

    public static void onlyTest(String... s) {
        testFew = s != null && s.length > 0;
        testsToBeTested = s;
    }

    public void andExpect(Output expectedOutput){
        String newName = getName() == null ? "" : "[" + getName() + "]" + " = ";
        if(testFew && Arrays.asList(testsToBeTested).contains(getName())) {
            try {
                Output actualOutput = this.method().call();
                if (!expectedOutput.equals(actualOutput)) {
                    System.out.println(newName + "test failed");
                    if (failFast) {
                        throw new AssertionError(expectedOutput.getClass().getSimpleName() + " are not equal. Expected: " + expectedOutput + ", Actual: " + actualOutput);
                    }
                } else {
                    System.out.println(newName + "test passed");
                }
            } catch (Exception exp){
                System.out.println(newName + "threw an exception. " + exp);
            }

        } else {
            System.out.println(newName + "test skipped");
        }
    }
}
