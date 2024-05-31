package person.prashant.questions.company.various;

import person.prashant.utility.DoubleInputSolutionTester;
import person.prashant.utility.SolutionTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class Questions {

    public static void main(String[] args){
        SolutionTester.<int[], Integer>startTest("Example 1.0")
                .callMethod(Questions::aggregate)
                .withInput(new int[]{1,2,3,4,5})
                .andExpect(15);

        DoubleInputSolutionTester.failFast();

        DoubleInputSolutionTester.<int[], Integer, Integer>startTest("Example 2.1")
                .callMethod(Questions::sumOfFirstNRecordsUsingCollectWithoutUsingCollector)
                .withInput(new int[]{1,2,3,4,5}, 3)
                .andExpect(6);

        DoubleInputSolutionTester.<int[], Integer, Integer>startTest("Example 2.2")
                .callMethod(Questions::sumOfFirstNRecordsUsingCollectWithoutUsingCollector)
                .withInput(new int[]{1,2,3,4,5}, 4)
                .andExpect(10);

        DoubleInputSolutionTester.<int[], Integer, Integer>startTest("Example 3.1")
                .callMethod(Questions::sumOfFirstNRecordsUsingCollectAndCollector)
                .withInput(new int[]{1,2,3,4,5}, 3)
                .andExpect(6);

        DoubleInputSolutionTester.<int[], Integer, Integer>startTest("Example 3.2")
                .callMethod(Questions::sumOfFirstNRecordsUsingCollectAndCollector)
                .withInput(new int[]{1,2,3,4,5}, 4)
                .andExpect(10);
    }

    private static int aggregate(int[] numbers){
        return Arrays.stream(numbers)
                .sum();
    }

    private static int sumOfFirstNRecordsUsingCollectWithoutUsingCollector(int[] numbers, int n){
        List<Integer> firstNElements = new ArrayList<>();
        Arrays.stream(numbers)
                .boxed()
                .collect(
                        () -> firstNElements,
                        (resultedList, input) -> {
                            if (resultedList.size() < n) {
                                resultedList.add(input);
                            }
                        },
                        (result1, result2) -> {
                            int remaining = n - result1.size();
                            if (remaining > 0) {
                                result1.addAll(result2.subList(0, Math.min(remaining, result2.size())));
                            }
                        }
                );
        // Sum the collected elements
        return firstNElements.stream().mapToInt(Integer::intValue).sum();
    }

    private static int sumOfFirstNRecordsUsingCollectAndCollector(int[] numbers, int n){
        // Custom collector to sum the first n elements
        return IntStream.of(numbers)
                .boxed()
                .collect(Collector.of(
                        () -> new int[]{0, 0}, // supplier: initial state {sum, count}
                        (acc, elem) -> {
                            if (acc[1] < n) { // accumulator: if count < n
                                acc[0] += elem; // add element to sum
                                acc[1]++; // increment count
                            }
                        },
                        (acc1, acc2) -> acc1, // combiner: no need to combine, just return one accumulator
                        acc -> acc[0] // finisher: return the sum
                ));
    }

    private static int sumOfLastNRecordsUsingSkip(int[] numbers, int n){
        return Arrays.stream(numbers)
                .skip(numbers.length - n)
                .sum();
    }

    private static int sumOfFirstNRecordsUsingLimit(int[] numbers, int n){
        return Arrays.stream(numbers)
                .limit(n)
                .sum();
    }


}
