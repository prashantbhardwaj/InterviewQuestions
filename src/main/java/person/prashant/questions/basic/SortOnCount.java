package person.prashant.questions.basic;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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
    }

    private static void sortOnCountThenSortOnGivenNumber(int... input){
        System.out.print("O: ");
        String val = Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((es1, es2) -> es1.getValue() == es2.getValue() ? Integer.compare(es1.getKey(), es2.getKey()) : Long.compare(es2.getValue(), es1.getValue()))
                .flatMap(entry -> LongStream.range(0, entry.getValue()).mapToObj(i -> entry.getKey()))
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        //.forEach(System.out::print);


        System.out.print(val);
    }

}
