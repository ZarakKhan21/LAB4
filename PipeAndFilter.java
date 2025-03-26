import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PipeAndFilter {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);
        input.add(7);
        input.add(8);
        input.add(9);
        input.add(10);

        // Create a pipeline with filter names
        Map<String, Function<List<Integer>, List<Integer>>> filters = new LinkedHashMap<>();
        filters.put("filterEvenNumbers", PipeAndFilter::filterEvenNumbers);
        filters.put("squareNumbers", PipeAndFilter::squareNumbers);
        filters.put("filterNumbersGreaterThanTen", PipeAndFilter::filterNumbersGreaterThanTen);
        filters.put("filterPrimeNumbers", PipeAndFilter::filterPrimeNumbers); // New filter to remove primes

        // Process the input through the pipeline
        System.out.println("Initial Input: " + input);
        List<Integer> result = processPipeline(input, filters);

        // Output the result
        System.out.println("Final Output: " + result);
    }

    // Process the input through the pipeline of filters
    private static List<Integer> processPipeline(List<Integer> input, Map<String, Function<List<Integer>, List<Integer>>> filters) {
        List<Integer> output = new ArrayList<>(input);
        for (Map.Entry<String, Function<List<Integer>, List<Integer>>> entry : filters.entrySet()) {
            output = entry.getValue().apply(output);
            System.out.println("After applying " + entry.getKey() + ": " + output);
        }
        return output;
    }

    // Filter to keep even numbers
    private static List<Integer> filterEvenNumbers(List<Integer> input) {
        return input.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    // Filter to square the numbers
    private static List<Integer> squareNumbers(List<Integer> input) {
        return input.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Filter to keep numbers greater than 10
    private static List<Integer> filterNumbersGreaterThanTen(List<Integer> input) {
        return input.stream()
                .filter(n -> n > 10)
                .collect(Collectors.toList());
    }

    // New filter to remove prime numbers
    private static List<Integer> filterPrimeNumbers(List<Integer> input) {
        return input.stream()
                .filter(n -> !isPrime(n))
                .collect(Collectors.toList());
    }

    // Helper function to check if a number is prime
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
