package person.prashant.questions.company.various;

import java.util.Arrays;
import java.util.stream.IntStream;

public class WeightedAverageUsing2SeparateArrays {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] weights = {1, 1, 1, 1, 1}; // weights corresponding to each number
        int n = 3; // number of elements to consider

        double weightedAverage = weightedAverageLastN(numbers, weights, n);
        System.out.println("Weighted average of last " + n + " numbers: " + weightedAverage);
    }

    public static double weightedAverageAll(int[] numbers, int[] weights) {
        int sumProduct = IntStream.range(0, numbers.length)
                .map(i -> numbers[i] * weights[i])
                .sum();
        int sumWeights = Arrays.stream(weights).sum();
        return (double) sumProduct / sumWeights;
    }

    public static double weightedAverageFirstN(int[] numbers, int[] weights, int n) {
        int sumProduct = IntStream.range(0, n)
                .map(i -> numbers[i] * weights[i])
                .sum();
        int sumWeights = Arrays.stream(weights, 0, n).sum();
        return (double) sumProduct / sumWeights;
    }

    public static double weightedAverageLastN(int[] numbers, int[] weights, int n) {
        int length = numbers.length;
        int sumProduct = IntStream.range(length - n, length)
                .map(i -> numbers[i] * weights[i])
                .sum();
        int sumWeights = Arrays.stream(weights, length - n, length).sum();
        return (double) sumProduct / sumWeights;
    }
}
