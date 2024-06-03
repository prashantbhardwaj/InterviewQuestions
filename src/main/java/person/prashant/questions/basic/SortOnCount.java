package person.prashant.questions.basic;

import person.prashant.utility.SolutionTester;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;


public class SortOnCount {

    public static void main(String[] args) {
        System.out.println("I: 1,2,3");
        sortOnCountThenSortOnGivenNumber(1,2,3);
        System.out.println();

        System.out.println("I: 3,2,1");
        sortOnCountThenSortOnGivenNumber(3,2,1);
        System.out.println();

        System.out.println("I: 1,2,2,3,3,3");
        sortOnCountThenSortOnGivenNumber(1,2,2,3,3,3);
        System.out.println();

        System.out.println("I: 1,2,3,4,4,5,5,6,7,7,7,8");
        sortOnCountThenSortOnGivenNumber(1,2,3,4,4,5,5,6,7,7,7,8);
        System.out.println();

        SolutionTester.<int[], String>startTest("Example 1.2")
                .callMethod(SortOnCount::sortOnCountThenSortOnGivenNumber)
                .withInput(new int[]{1,2,3,4,4,5,5,6,7,7,7,8})
                .andExpect("7,7,7,4,4,5,5,1,2,3,6,8");
    }

    private static String sortOnCountThenSortOnGivenNumber(int... input){
        return Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .sorted((es1, es2) -> es1.getValue() == es2.getValue() ? Integer.compare(es1.getKey(), es2.getKey()) : Integer.compare(es2.getValue().size(), es1.getValue().size()))
                .flatMap(entry -> entry.getValue().stream())
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

}
