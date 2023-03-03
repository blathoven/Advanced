package SetsAndMapsAdvanced;
import java.util.*;
import java.util.stream.Collectors;

public class LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> digits = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .sorted((n1, n2) -> n2.compareTo(n1)).collect(Collectors.toList());

        int counter = 0;
        for (int currentElement : digits) {
            System.out.print(currentElement + " ");

            counter++;

            if (counter == 3) {
                break;
            }
        }
    }
}
