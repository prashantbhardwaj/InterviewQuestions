package person.prashant.questions.company.various;

import java.util.Arrays;

public class WeightedAverageUsingPair {

    public static class Pair {
        private final int number;
        private final int weight;

        private Pair(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }

        public static Pair of(int number, int weight) {
            return new Pair(number, weight);
        }

        public int getNumber() {
            return number;
        }

        public int getWeight() {
            return weight;
        }

        public Pair add(Pair other) {
            return new Pair(this.number + other.number, this.weight + other.weight);
        }
    }

    public static void main(String[] args) {
        Pair[] pairs = {
                Pair.of(1, 1),
                Pair.of(2, 1),
                Pair.of(3, 1),
                Pair.of(4, 1),
                Pair.of(5, 1)
        };

        // Weighted average of all numbers
        double weightedAverageAll = weightedAverageAll(pairs);
        System.out.println("Weighted average of all numbers: " + weightedAverageAll);

        // Weighted average of the first n numbers
        int n = 3; // Number of elements to consider
        double weightedAverageFirstN = weightedAverageFirstN(pairs, n);
        System.out.println("Weighted average of first " + n + " numbers: " + weightedAverageFirstN);

        // Weighted average of the last n numbers
        double weightedAverageLastN = weightedAverageLastN(pairs, n);
        System.out.println("Weighted average of last " + n + " numbers: " + weightedAverageLastN);
    }

    // Weighted average of all numbers
    public static double weightedAverageAll(Pair[] pairs) {
        int sumProduct = Arrays.stream(pairs)
                .mapToInt(pair -> pair.getNumber() * pair.getWeight())
                .sum();
        int sumWeights = Arrays.stream(pairs)
                .mapToInt(Pair::getWeight)
                .sum();
        return (double) sumProduct / sumWeights;
    }

    // Weighted average of the first n numbers
    public static double weightedAverageFirstN(Pair[] pairs, int n) {
        int sumProduct = Arrays.stream(pairs)
                .limit(n)
                .mapToInt(pair -> pair.getNumber() * pair.getWeight())
                .sum();
        int sumWeights = Arrays.stream(pairs)
                .limit(n)
                .mapToInt(Pair::getWeight)
                .sum();
        return (double) sumProduct / sumWeights;
    }

    // Weighted average of the last n numbers
    public static double weightedAverageLastN(Pair[] pairs, int n) {
        int length = pairs.length;
        int sumProduct = Arrays.stream(pairs)
                .skip(length - n)
                .mapToInt(pair -> pair.getNumber() * pair.getWeight())
                .sum();
        int sumWeights = Arrays.stream(pairs)
                .skip(length - n)
                .mapToInt(Pair::getWeight)
                .sum();
        return (double) sumProduct / sumWeights;
    }

    // Weighted average of all numbers
    public static double weightedAverageAllUsingReduce(Pair[] pairs) {
        Pair result = Arrays.stream(pairs)
                .map(pair -> Pair.of(pair.getNumber() * pair.getWeight(), pair.getWeight()))
                .reduce(Pair.of(0, 0), Pair::add);
        return (double) result.getNumber() / result.getWeight();
    }

    // Weighted average of the first n numbers
    public static double weightedAverageFirstNUsingReduce(Pair[] pairs, int n) {
        Pair result = Arrays.stream(pairs)
                .limit(n)
                .map(pair -> Pair.of(pair.getNumber() * pair.getWeight(), pair.getWeight()))
                .reduce(Pair.of(0, 0), Pair::add);
        return (double) result.getNumber() / result.getWeight();
    }

    // Weighted average of the last n numbers
    public static double weightedAverageLastNUsingReduce(Pair[] pairs, int n) {
        int length = pairs.length;
        Pair result = Arrays.stream(pairs)
                .skip(length - n)
                .map(pair -> Pair.of(pair.getNumber() * pair.getWeight(), pair.getWeight()))
                .reduce(Pair.of(0, 0), Pair::add);
        return (double) result.getNumber() / result.getWeight();
    }
}
