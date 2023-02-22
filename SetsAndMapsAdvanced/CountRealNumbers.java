package SetsAndMapsAdvanced;

import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbersCount = new LinkedHashMap<>();

        for (double currentNumber : numbers) {

            if (!numbersCount.containsKey(currentNumber)) {
                numbersCount.put(currentNumber, 1);
            } else {
                numbersCount.put(currentNumber, numbersCount.get(currentNumber) + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : numbersCount.entrySet()) {
            System.out.printf("%.1f -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
