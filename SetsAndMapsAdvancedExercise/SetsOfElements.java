package SetsAndMapsAdvancedExercise;
import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setsSize = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < setsSize[0] + setsSize[1]; i++) {
            int currentValue = Integer.parseInt(scanner.nextLine());

            if (i < setsSize[0]) {
                firstSet.add(currentValue);
            } else {
                secondSet.add(currentValue);
            }
        }
        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
