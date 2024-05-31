package person.prashant.questions.company.various;

import java.util.Arrays;

public class WeightedAverageUsing2DArray {

    public static void main(String[] args) {
        int[][] numberWeightPairs = {
                {1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 1}
        };
        int n = 3; // Number of elements to consider

        double weightedAverage = weightedAverageLastN(numberWeightPairs, n);
        System.out.println("Weighted average of last " + n + " numbers: " + weightedAverage);
    }

    public static double weightedAverageAll(int[][] numberWeightPairs) {
        int sumProduct = Arrays.stream(numberWeightPairs)
                .mapToInt(pair -> pair[0] * pair[1])
                .sum();
        int sumWeights = Arrays.stream(numberWeightPairs)
                .mapToInt(pair -> pair[1])
                .sum();
        return (double) sumProduct / sumWeights;
    }

    public static double weightedAverageFirstN(int[][] numberWeightPairs, int n) {
        int sumProduct = Arrays.stream(numberWeightPairs)
                .limit(n)
                .mapToInt(pair -> pair[0] * pair[1])
                .sum();
        int sumWeights = Arrays.stream(numberWeightPairs)
                .limit(n)
                .mapToInt(pair -> pair[1])
                .sum();
        return (double) sumProduct / sumWeights;
    }

    public static double weightedAverageLastN(int[][] numberWeightPairs, int n) {
        int length = numberWeightPairs.length;
        int sumProduct = Arrays.stream(numberWeightPairs)
                .skip(length - n)
                .mapToInt(pair -> pair[0] * pair[1])
                .sum();
        int sumWeights = Arrays.stream(numberWeightPairs)
                .skip(length - n)
                .mapToInt(pair -> pair[1])
                .sum();
        return (double) sumProduct / sumWeights;
    }
}
